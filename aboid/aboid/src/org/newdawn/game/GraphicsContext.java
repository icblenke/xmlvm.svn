package org.newdawn.game;

public interface GraphicsContext {
	public static final int BLACK = 0x000000;
	public static final int WHITE = 0xFFFFFF;
	public static final int YELLOW = 0xFFFF00;
	public static final int RED = 0xFF0000;
	public static final int BLUE = 0x0000FF;
	public static final int GREEN = 0x00FF00;
	
	public void setColor(int col);
	
	public void drawRect(int x, int y, int width, int height);
	
	public void fillRect(int x, int y, int width, int height);
	
	public void fillOval(int x, int y, int width, int height);
	
	public void drawString(String str, int x, int y);
	
	public int stringWidth(String str);
	
	public void setFont(Typeface face);
	
	public Typeface getFont();
	
	public void drawImage(OffscreenImage image, int x, int y);
	
	public void drawImage(OffscreenImage image, int dx, int dy, int sx, int sy, int width, int height);
	
	public void translate(int x, int y);
	
	public void clear(int width, int height);
	
	public void setAntialias(boolean anti);
}
