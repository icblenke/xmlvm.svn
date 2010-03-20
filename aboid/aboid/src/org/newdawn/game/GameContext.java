package org.newdawn.game;

import java.io.IOException;

public interface GameContext {

	public Typeface loadTypeface(String typeface) throws IOException;
	
	public OffscreenImage loadImage(String ref, int trans) throws IOException;
	
	public void changeState(GameState state);
}
