package org.newdawn.game.java2d;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import org.newdawn.game.GraphicsContext;
import org.newdawn.game.Typeface;
import org.newdawn.util.ResourceLoader;

public class Java2DTypeface implements Typeface {
	private Font font;

	Java2DTypeface(Font font) {
		this.font = font;
	}
	
	public Java2DTypeface(String ref) throws IOException {
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.getResource(ref));
		} catch (FontFormatException e) {
			IOException x = new IOException("Failed to load: "+ref);
			x.initCause(e);
			
			throw x;
		}
	}
	
	public Font getFont() {
		return font;
	}

	public Typeface derive(int size) {
		return new Java2DTypeface(font.deriveFont((float) size));
	}

	public int getWidth(GraphicsContext c, String str) {
		Java2DGraphicsContext context = (Java2DGraphicsContext) c;
		
		return context.getGraphics().getFontMetrics(font).stringWidth(str);
	}
	
	public String getName() {
		return font.getName();
	}
}
