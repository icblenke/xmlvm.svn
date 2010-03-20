package org.newdawn.game;

public interface Typeface {

	public Typeface derive(int size);
	
	public int getWidth(GraphicsContext context, String str);
	
	public String getName();
}
