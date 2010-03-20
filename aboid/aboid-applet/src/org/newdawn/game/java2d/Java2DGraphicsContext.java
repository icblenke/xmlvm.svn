package org.newdawn.game.java2d;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import org.newdawn.game.GraphicsContext;
import org.newdawn.game.OffscreenImage;
import org.newdawn.game.Typeface;

public class Java2DGraphicsContext implements GraphicsContext {
	private Graphics2D g;
	private Typeface typeface;
	
	public Java2DGraphicsContext(Graphics2D g) {
		this.g = g;
	}
	
	Graphics2D getGraphics() {
		return g;
	}
	
	void setGraphics(Graphics2D g) {
		this.g = g;
	}

	public void fillRect(int x, int y, int width, int height) {
		g.fillRect(x, y, width, height);
	}

	public void setColor(int col) {
		g.setColor(new Color(col, col > 0xFFFFFF));
	}

	public void drawString(String str, int x, int y) {
		g.drawString(str,x,y);
	}

	public void setFont(Typeface face) {
		Java2DTypeface j2d = (Java2DTypeface) face;
		this.typeface = face;
		
		g.setFont(j2d.getFont());
	}

	public void drawImage(OffscreenImage image, int x, int y) {
		g.drawImage(((Java2DOffscreenImage) image).getImage(), x, y, null);
	}

	public Typeface getFont() {
		if (typeface == null) {
			typeface = new Java2DTypeface(g.getFont());
		}
		
		return typeface;
	}

	public void fillOval(int x, int y, int width, int height) {
		g.fillOval(x,y,width,height);
	}

	public void setColor(float r, float g, float b, float a) {
		int value = ((int) (a * 255) << 24) | ((int) (r * 255) << 16) | ((int) (g * 255) << 8) | ((int) (b * 255));
		setColor(value);
	}

	public int stringWidth(String str) {
		return g.getFontMetrics().stringWidth(str);
	}

	public void translate(int x, int y) {
		g.translate(x,y);
	}

	public void drawImage(OffscreenImage image, int dx, int dy, int sx, int sy, int width, int height) {
		g.drawImage(((Java2DOffscreenImage) image).getImage(), dx, dy, dx+width, dy+height,
				    sx,sy,sx+width,sy+height,null);
	}
	
	public void clear(int width, int height) {
		Composite old = g.getComposite();
		g.setComposite(AlphaComposite.Clear);
		g.fillRect(0,0,width,height);
		g.setComposite(old);
	}

	public void setAntialias(boolean anti) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, anti ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
	}

	public void clearClip() {
		g.setClip(null);
	}

	public void setClip(int x, int y, int width, int height) {
		g.setClip(x, y, width, height);
	}

	public void drawRect(int x, int y, int width, int height) {
		g.drawRect(x, y, width, height);
	}
}
