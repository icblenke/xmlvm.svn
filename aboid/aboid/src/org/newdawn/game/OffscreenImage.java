package org.newdawn.game;

public interface OffscreenImage {
	public static final int OPAQUE = 1;
	public static final int BITMASK = 2;
	public static final int TRANSLUCENT = 3;
	
	public int getWidth();
	
	public int getHeight();
}
