/*
 * Copyright (c) 2004-2009 XMLVM --- An XML-based Programming Language
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 675 Mass
 * Ave, Cambridge, MA 02139, USA.
 * 
 * For more information, visit the XMLVM Home Page at http://www.xmlvm.org
 */

package org.xmlvm.demo.xokoban;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;

/**
 * The controller class for the Xokoban game.
 */
public class GameController implements MoveFinishedHandler, Runnable {
    /** A flag to indicate whether sensor events will be processed or not. */
    private boolean         gamePaused              = true;

    /** The current level. */
    private int             currentLevel            = 0;

    /** Indicates whether the current level has been started. */
    private boolean         levelStarted            = false;

    /** The number of moves. */
    private int             moveCount               = 0;

    /** A representation of the game's man game piece. */
    private Man             man                     = null;

    /** A list of all ball game pieces. */
    private List<GamePiece> balls                   = null;

    /** A list of all goal game pieces. */
    private List<GamePiece> goals                   = null;

    /** The current game board. */
    private Board           board                   = null;

    /** The {@link GameView} associated with this GameController. */
    private GameView        gameView                = null;

    /** The splash view shown right after the start of the application. */
    private SplashView      splashView;

    /** The info screen contains instructions and settings. */
    private InfoView        infoView;

    private AlertDialog     currentLevelDialog      = null;

    private AlertDialog     changeLevelDialog       = null;

    private AlertDialog     congratulationDialog    = null;

    /** Indicated the next X-direction the man should move to. */
    private int             nextDX;

    /** Indicated the next Y-direction the man should move to. */
    private int             nextDY;

    /** Stop man when current move is finished. */
    private boolean         stopMovement            = true;

    /** Set to true if timer is running. */
    private boolean         timerIsRunning          = false;

    /** Delay between two timer ticks. */
    private long            animationDelay;

    private static int      DEFAULT_DELAY_IN_MILLIS = 60;

    private Handler         timerHandler            = new Handler();

    /**
     * Instantiates a new GameController and connects it to the given
     * {@link GameView}.
     * 
     * @param gameView
     *            The GameView used to display the game.
     * @param splashView
     *            The SplashView that should be used within the game.
     * @param infoView
     *            The InfoView that should be used within the game.
     * @param currentLevel
     *            The current level.
     */
    public GameController(GameView gameView, SplashView splashView, InfoView infoView,
            int currentLevel) {
        this.gameView = gameView;
        this.splashView = splashView;
        this.infoView = infoView;
        this.infoView.setOnCloseHandler(new OnCloseHandler() {
            @Override
            public void onClose() {
                gamePaused = false;
            }
        });
        this.currentLevel = currentLevel;
    }

    /**
     * Returns whether the current level is finished.
     * 
     * @return true if the level is finished, false otherwise.
     */
    public boolean isLevelFinished() {
        for (int i = 0; i < goals.size(); i++) {
            Goal goal = (Goal) goals.get(i);
            if (getBallAtPosition(goal.getX(), goal.getY()) == null) {
                return false;
            }
        }
        return true;
    }

    public void setMovingSpeed(float x, float y) {
        x = Math.abs(x);
        y = Math.abs(y);
        float max = Math.max(x, y);
        int newAnimationDelay = (int) ((getDelayInMillis() * 1.6) - (8f * max));
        if (newAnimationDelay < 5)
            newAnimationDelay = 5;
        animationDelay = newAnimationDelay;
    }

    /**
     * Schedule the man to move in a certain direction designated by the input
     * parameters. If the man is currently stop, he will start moving
     * immediately. Otherwise the new direction will be considered after the
     * current move is finished (i.e., the man has reached the new tile).
     * 
     * @param dx
     *            New X-direction (either -1, 0, or 1)
     * @param dy
     *            New Y-direction (either -1, 0, or 1)
     */
    public void scheduleMoveMan(int dx, int dy) {
        nextDX = dx;
        nextDY = dy;
        if (moveMan() && !timerIsRunning) {
            timerIsRunning = true;
            stopMovement = false;
            timerHandler.removeCallbacks(this);
            animationDelay = getDelayInMillis();
            timerHandler.postDelayed(this, animationDelay);
        }
    }

    /**
     * Schedule to stop the man. The timer can't be stopped right away because
     * the current move first needs to complete (i.e., the man needs to reach
     * the next tile).
     */
    public void scheduleStopMan() {
        stopMovement = true;
    }

    private int getDelayInMillis() {
        return (int) (DEFAULT_DELAY_IN_MILLIS * (20f / man.getTileSize()));
    }

    /**
     * Attempts to move the man in the direction given by variables
     * {@link newDX} and {@link newDY}.
     * 
     * @return Returns true if the man can move in the desired direction.
     */
    private boolean moveMan() {
        if (man == null || man.isMoving()) {
            return false;
        }
        int newX = man.getX() + nextDX;
        int newY = man.getY() + nextDY;

        // Check wall
        if (board.getBoardPiece(newX, newY) == Board.WALL) {
            return false;
        }

        // Check ball and piece behind it
        Ball adjacentBall = getBallAtPosition(newX, newY);
        if (adjacentBall != null
                && (getBallAtPosition(newX + nextDX, newY + nextDY) != null || board.getBoardPiece(
                        newX + nextDX, newY + nextDY) == Board.WALL)) {
            return false;
        }

        // Move man only
        levelStarted = true;
        moveCount++;
        if (adjacentBall == null) {
            man.startMoving(nextDX, nextDY);
        }
        // Move man and ball
        else {
            adjacentBall.startMoving(nextDX, nextDY);
            man.startMoving(nextDX, nextDY);
        }
        return true;
    }

    /**
     * Returns the ball at the requested position.
     * 
     * @param x
     *            The x coordinate to check for a ball.
     * @param y
     *            The y coordinate to check for a ball.
     * @return If a {@link Ball} exists at the requested location, it returns
     *         it. Null otherwise.
     */
    private Ball getBallAtPosition(int x, int y) {
        for (int i = 0; i < balls.size(); i++) {
            Ball b = (Ball) balls.get(i);
            if (b.getX() == x && b.getY() == y) {
                return b;
            }
        }

        return null;
    }

    /**
     * Sets the man of the game.
     */
    public void setMan(Man man) {
        this.man = man;
    }

    /**
     * Adds a ball to the game.
     */
    public void addBall(Ball ball) {
        balls.add(ball);
    }

    /**
     * Adds a goal to the game.
     */
    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    public void loadLevel(boolean showLevel) {
        loadLevel(currentLevel, showLevel);
    }

    /**
     * Loads the give level. Before the level is started a Dialog shows the
     * number of the level being started.
     * 
     * @param level
     *            The level to be loaded.
     * @param showLevel
     *            Determines whether the loaded level will be indicated with a
     *            DialogBox
     */
    public void loadLevel(int level, boolean showLevel) {
        // Pause game and store current level
        gamePaused = true;
        currentLevel = level;
        levelStarted = false;

        // Create and display the level's board
        board = new Board(new CharField(Levels.getLevel(level), Board.BOARD_WIDTH,
                Board.BOARD_HEIGHT));
        balls = new ArrayList<GamePiece>();
        goals = new ArrayList<GamePiece>();

        gameView.displayBoard(board);

        // Display current level
        if (showLevel) {
            currentLevelDialog = new AlertDialog.Builder(gameView.getActivity()).setTitle(
                    "Level: " + (currentLevel + 1)).setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            gamePaused = false;
                        }
                    }).create();
            currentLevelDialog.show();
        } else {
            gamePaused = false;
        }
    }

    /**
     * Shows a dialog allowing the user to reset the current level or to proceed
     * to the next level.
     */
    public void showLevelDialog() {
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                boolean showLevelDialog = false;
                // First button: Test for previous level and go back to previous
                // level if necessary
                if (which == DialogInterface.BUTTON1 && !levelStarted && currentLevel > 0) {
                    currentLevel--;
                    // showLevelDialog = true;
                }

                // Second button: Increase current level to proceed to next
                // level
                if (which == DialogInterface.BUTTON3) {
                    currentLevel++;
                    // showLevelDialog = true;
                }

                changeLevelDialog.dismiss();

                if (which != DialogInterface.BUTTON2) {
                    loadLevel(currentLevel, showLevelDialog);
                }
            }

        };
        changeLevelDialog = new AlertDialog.Builder(gameView.getActivity()).create();
        changeLevelDialog.setTitle("   Current Level: " + (currentLevel + 1) + "   ");
        if (!levelStarted && currentLevel > 0) {
            changeLevelDialog.setButton("Previous", listener);
        } else {
            changeLevelDialog.setButton("Reset", listener);
        }
        changeLevelDialog.setButton2("Cancel", listener);

        if (currentLevel < Levels.getSize() - 1) {
            changeLevelDialog.setButton3("Next", listener);
        }
        changeLevelDialog.show();
    }

    /**
     * Shows a dialog allowing the user to reset the current level or to proceed
     * to the next level.
     */
    public void showCongratulationDialog() {

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                loadLevel(0, false);
            }

        };

        congratulationDialog = new AlertDialog.Builder(gameView.getActivity()).create();
        congratulationDialog.setTitle("Congratulations! All levels finished. Skipping to level 1.");
        congratulationDialog.setButton("OK", listener);
        congratulationDialog.show();
    }

    /**
     * Shows the splashScreen until the user taps the screen.
     */
    public void showSplashScreen() {
        gamePaused = true;
        splashView.show();
    }

    /**
     * Shows the {@link InfoView} instance associated with this GameController.
     */
    public void showInfoView() {
        gamePaused = true;
        infoView.show();
    }

    /**
     * Returns the number of moves already made in the current game.
     * 
     * @return The number of moves.
     */
    public int getMoveCount() {
        return moveCount;
    }

    /**
     * Returns the current level.
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Returns whether the game is paused.
     */
    public boolean isGamePaused() {
        return gamePaused;
    }

    @Override
    public void onMoveFinished() {
        if (isLevelFinished()) {
            timerHandler.removeCallbacks(this);

            // Let's delay ending the level so it is not too instant.
            timerHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    timerIsRunning = false;
                    stopMovement = true;
                    // More levels left
                    if (currentLevel < Levels.getSize() - 1) {
                        currentLevel++;
                        loadLevel(currentLevel, true);
                    }
                    // All levels finished: Congratulate and wrap to level 1
                    else {
                        showCongratulationDialog();
                    }
                }
            }, 500);
            return;
        }
        if (!stopMovement) {
            stopMovement = !moveMan();
        }
        timerIsRunning = !stopMovement;
    }

    /**
     * Should be called, before the object is destroyed.
     */
    public void onDestroy() {
        if (currentLevelDialog != null) {
            currentLevelDialog.dismiss();
            currentLevelDialog = null;
        }

        if (changeLevelDialog != null) {
            changeLevelDialog.dismiss();
            changeLevelDialog = null;
        }

        if (congratulationDialog != null) {
            congratulationDialog.dismiss();
            congratulationDialog = null;
        }
    }

    /**
     * Called by the input controller when the user tapped on screen.
     * 
     * @param x
     *            X-coordinate of touch.
     * @param y
     *            Y-coordinate of touch.
     */
    public void onTap(float x, float y) {
        if (splashView.isViewShown()) {
            splashView.hide();

            Xokoban activity = (Xokoban) gameView.getActivity();
            if (activity.isFirstRun()) {
                showInfoView();
            } else {
                loadLevel(currentLevel, true);
            }
        } else if (!gamePaused) {
            if (gameView.isInsideInfoLogo(x, y)) {
                showInfoView();
            } else if (gameView.isInsideLevelsLogo(x, y)) {
                showLevelDialog();
            }
        }
    }

    @Override
    public void run() {
        if (timerIsRunning) {
            timerHandler.postDelayed(this, animationDelay);
            gameView.getMover().doNextAnimationStep();
        }
    }
}