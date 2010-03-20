package org.newdawn.game.iphone;

import org.newdawn.game.GraphicsContext;
import org.newdawn.game.OffscreenImage;
import org.newdawn.game.Typeface;
import org.xmlvm.iphone.CGContext;
import org.xmlvm.iphone.CGRect;

public class IPhoneGraphicsContext implements GraphicsContext {
	private CGContext ctx;
	private Typeface font;
	
	public IPhoneGraphicsContext() {
	}
	
	public CGContext getContext() {
		return ctx;
	}
	
	public void refresh() {
        ctx = CGContext.UICurrentContext();
	}
	
	@Override
	public void clear(int width, int height) {
		setColor(BLACK);
		fillRect(0,0,width,height);
	}

	@Override
	public void drawImage(OffscreenImage image, int x, int y) {
		((IPhoneOffscreenImage) image).getUIImage().draw(x,y);
	}

	@Override
	public void drawImage(OffscreenImage image, int dx, int dy, int sx, int sy,
			int width, int height) {
		// skip if offscreen
		if ((dx+width <= 0) && (dy+height <= 0)) {
			return;
		}
		
		ctx.storeState();
		setClip(dx,dy,width,height);
		((IPhoneOffscreenImage) image).getUIImage().draw(dx - sx, dy - sy);
		ctx.restoreState();
	}

	@Override
	public void drawRect(int x, int y, int width, int height) {
		ctx.strokeRect(new CGRect(x,y,width,height));
	}

	@Override
	public void drawString(String str, int x, int y) {
		ctx.showTextAtPoint(x,y,str);
	}

	@Override
	public void fillOval(int x, int y, int width, int height) {
		ctx.fillEllipseInRect(new CGRect(x,y,width,height));
	}

	@Override
	public void fillRect(int x, int y, int width, int height) {
		ctx.fillRect(new CGRect(x,y,width,height));
	}

	@Override
	public Typeface getFont() {
		return font;
	}

	@Override
	public void setAntialias(boolean anti) {
	}

	private void setClip(int x, int y, int width, int height) {
		ctx.clipToRect(new CGRect(x,y,width,height));
	}

	@Override
	public void setColor(int col) {
		float[] array = colToArray(col);
		ctx.setFillColor(array);
		ctx.setStrokeColor(array);
		
		ctx.setAlpha(getAlpha(col));
	}

	@Override
	public void setFont(Typeface face) {
		this.font = face;
		
		ctx.setFont(((IPhoneTypeface) font).getFont());
		ctx.setFontSize(((IPhoneTypeface) font).getSize());
	}

	@Override
	public int stringWidth(String str) {
		return font.getWidth(this, str);
	}

	@Override
	public void translate(int x, int y) {
		ctx.translate(x,y);
	}

	private float getAlpha(int col) {
		int a = (col >> 24) & 0xFF;
		if (a == 0) {
			a = 0xFF;
		}
		
		return a / 255.0f;
	}
	
	private float[] colToArray(int col) {
		int r = (col >> 16) & 0xFF;
		int g = (col >> 8) & 0xFF;
		int b = (col) & 0xFF;
		
		return new float[] {r / 255.0f,g / 255.0f,b / 255.0f, 1.0f};
	}
}
