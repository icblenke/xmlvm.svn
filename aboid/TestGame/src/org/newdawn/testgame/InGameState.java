package org.newdawn.testgame;

import org.newdawn.game.GameContext;
import org.newdawn.game.GameState;
import org.newdawn.game.GraphicsContext;

public class InGameState implements GameState {
	private int starx;
	private int stary;
	private String msg = "Keep Clicking Stars!";
	private int count;
	
	public void enter(GameContext game) {
		newStar();
	}

	private void newStar() {
		starx = (int) (Math.random() * 280);
		stary = (int) (Math.random() * 440);
	}
	
	public void init(GameContext game) {
	}

	public boolean keyPressed(int keyCode) {
		return false;
	}

	public void leave(GameContext game) {
	}

	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
	}

	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
	}

	public void mousePressed(int x, int y, int button) {
		if ((x > starx) && (y > stary) && (x < starx + 40) && (y < stary + 40)) {
			newStar();
			count++;
		}
	}

	public void mouseReleased(int x, int y, int button) {
	}

	public void render(GameContext game, GraphicsContext g) {
		g.setColor(GraphicsContext.BLACK);
		g.fillRect(0,0,320,480);
		g.drawImage(Images.star, starx, stary);
		g.setColor(GraphicsContext.WHITE);
		g.setFont(Images.font);
		g.drawString(msg, (320 - Images.font.getWidth(g, msg)) /2, 470);
		g.drawString(""+count, 7,25);
	}

	public void update(GameContext game) {
	}

}
