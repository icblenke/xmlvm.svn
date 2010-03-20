package org.newdawn.game;

import java.io.IOException;

public interface Game {
	
	public void preload(GameConfig config) throws IOException;
	
	public void init(GameContext context);
	
	public GameState[] getStates(GameContext context);
	
	public GameState getInitialState(GameContext context);
	
	public boolean requiresKeyboardFocus();
}
