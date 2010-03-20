package org.newdawn.game;


public interface GameState {

	public void init(GameContext game);
	
	public void render(GameContext game, GraphicsContext g);
	
	public void update(GameContext game);
	
	/**
	 * Notification that a key was pressed
	 * 
	 * @param keyCode The code of the key pressed
	 * @return True if input should continue process events
	 */
	public boolean keyPressed(int keyCode);
	
	public void mousePressed(int x, int y, int button);
	
	public void mouseReleased(int x, int y, int button);
	
	public void mouseMoved(int oldx, int oldy, int newx, int newy);
	
	public void mouseDragged(int oldx, int oldy, int newx, int newy);
	
	public void enter(GameContext game);
	
	public void leave(GameContext game);
}
