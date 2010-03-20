package org.newdawn.game.java2d;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.newdawn.game.Game;
import org.newdawn.game.GameContext;
import org.newdawn.game.GameState;
import org.newdawn.game.GraphicsContext;
import org.newdawn.game.OffscreenImage;
import org.newdawn.game.Typeface;
import org.newdawn.util.ResourceLoader;

public class GamePanel extends Canvas implements GameContext {
	private static final long serialVersionUID = 5496577162024999390L;
	
	private static final int FPS = 30;
	private static final int FRAME_TIME = 1000 / FPS;
	private long lastFrame;
	private boolean running = true;
	
	private int fps = 0;
	private int noFocus = 0;
	private boolean limitFPS = true;
	
	private KeyHandler keyHandler = new KeyHandler();
	private MouseHandler mouseHandler = new MouseHandler();
	
	private GameState gameState;
	private ArrayList events = new ArrayList();
	private Game game;
	private boolean continueInput = false;
	
	public GamePanel(Game game) {
		this.game = game;
		
		setBackground(Color.black);
		setIgnoreRepaint(true);
	}
	
	public void end() {
		running = false;
	}
	
	public void gameInit() {
		running = true;
		
		setFocusable(true);
		requestFocusInWindow();
		requestFocus();
		
		addKeyListener(keyHandler);
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);
		
		game.init(this);
		
		GameState[] states = game.getStates(this);
		for (int i=0;i<states.length;i++) {
			states[i].init(this);
		}
		
		gameState = game.getInitialState(this);
		gameState.enter(this);
	}
	
	public void gameLoop() {
		createBufferStrategy(2);
		BufferStrategy strategy = getBufferStrategy();
		
		// timing and fps tracking
		long lastFPS = System.currentTimeMillis();
		int frameCount = 0;
		
		Java2DGraphicsContext graphicsContext = new Java2DGraphicsContext(null);
		
		while (running) {
			lastFrame = System.currentTimeMillis();
			gameUpdate();
			
			if (isVisible()) {
				Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
				graphicsContext.setGraphics(g);
				
				gameRender(graphicsContext); 
				g.dispose();
				strategy.show();
			}
			
			frameCount++;
			if (System.currentTimeMillis() - lastFPS > 1000) {
				fps = frameCount;
				frameCount = 0;
				lastFPS = System.currentTimeMillis();
			}
			
			// pause to not kill the CPU
			if (limitFPS) {
				while ((System.currentTimeMillis() - lastFrame) < FRAME_TIME) {
					try {
						Thread.sleep(15);
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}
	
	public void gameUpdate() {
		fireEvents();
		
		gameState.update(this);
	}
	
	public void gameRender(GraphicsContext g) {
		gameState.render(this, g);
		
		if (game.requiresKeyboardFocus()) {
			if (!hasFocus()) {
				noFocus++;
			} else {
				noFocus = 0;
			}
			if (noFocus > 5) {
				noFocus--;
				g.setColor(0xAA000000);
				g.fillRect(0,200,640,70);
				g.setFont(g.getFont().derive(40));
				g.setColor(GraphicsContext.WHITE);
				g.drawString("paused - click to play", 130, 250);
			}
		}
	
//		g.setColor(GraphicsContext.WHITE);
//		g.setFontSize(14);
//		g.drawString("FPS: "+fps,10,15);
	}
	
	private void fireEvents() {
		synchronized (events) {
			continueInput = true;
			while (events.size() > 0) {
				((Runnable) events.get(0)).run();
				if (!continueInput) {
					break;
				}
				events.remove(0);
			}
		}
	}
	
	private void addEvent(Runnable runme) {
		synchronized (events) {
			events.add(runme);
		}
	}
	
	private class KeyHandler implements KeyListener {
		public void keyPressed(final KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_F8) {
				limitFPS = !limitFPS;
			}
			
			addEvent(new Runnable()  {
				public void run() {
					continueInput = gameState.keyPressed(e.getKeyCode());
				}
			});
		}

		public void keyReleased(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
		}
		
		public void tabPressed() {
			addEvent(new Runnable()  {
				public void run() {
					continueInput = gameState.keyPressed(KeyEvent.VK_TAB);
				}
			});
		}
	}
	
	private class MouseHandler extends MouseAdapter implements MouseMotionListener {
		private int lastx;
		private int lasty;
		
		private void update(MouseEvent e) {
			lastx = e.getX();
			lasty = e.getY();
		}
		
		public void mouseDragged(final MouseEvent e) {
			addEvent(new Runnable()  {
				public void run() {
					gameState.mouseDragged(lastx, lasty, e.getX(), e.getY());
				}
			});
			update(e);
		}

		public void mouseMoved(final MouseEvent e) {
			addEvent(new Runnable()  {
				public void run() {
					gameState.mouseMoved(lastx, lasty, e.getX(), e.getY());
				}
			});
			update(e);
		}

		public void mouseClicked(MouseEvent e) {
			update(e);
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
			update(e);
		}

		public void mousePressed(final MouseEvent e) {
			addEvent(new Runnable()  {
				public void run() {
					gameState.mousePressed(e.getX(), e.getY(), e.getButton());
				}
			});
			update(e);
		}

		public void mouseReleased(final MouseEvent e) {
			addEvent(new Runnable()  {
				public void run() {
					gameState.mouseReleased(e.getX(), e.getY(), e.getButton());
				}
			});
			update(e);
		}
	}

	public void changeState(GameState state) {
		if (gameState != null) {
			gameState.leave(this);
		}
		
		this.gameState = state;
		
		if (gameState != null) {
			gameState.enter(this);
		}
	}

	public OffscreenImage loadImage(String ref, int trans) throws IOException {
		BufferedImage loaded = ImageIO.read(ResourceLoader.getResource(ref));
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		BufferedImage compatibleImage = gc.createCompatibleImage(loaded.getWidth(), loaded.getHeight(), trans);
		compatibleImage.getGraphics().drawImage(loaded, 0, 0, null);
		
		return new Java2DOffscreenImage(compatibleImage);
	}

	public Typeface loadTypeface(String typeface) throws IOException {
		return new Java2DTypeface(typeface);
	}
}
