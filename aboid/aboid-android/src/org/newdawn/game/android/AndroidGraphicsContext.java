package org.newdawn.game.android;

import org.newdawn.game.GraphicsContext;
import org.newdawn.game.OffscreenImage;
import org.newdawn.game.Typeface;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Paint.Style;

public class AndroidGraphicsContext implements GraphicsContext {
	private Canvas canvas;
	private int color = 0xFFFFFF;
	private Typeface font = new AndroidTypeface(android.graphics.Typeface.DEFAULT, "default", 16);
	private Paint paint = new Paint();
	private Rect src = new Rect();
	private Rect dst = new Rect();
	private RectF rect = new RectF();
	
	public AndroidGraphicsContext(Canvas canvas) { 
		this.canvas = canvas;
		
		setColor(color);
		setFont(font);
	}
	
	@Override
	public void clear(int width, int height) {
		setColor(0x000000);
		fillRect(0,0,width,height);
	}

	@Override
	public void drawImage(OffscreenImage image, int x, int y) {
		Bitmap bitmap = ((AndroidOffscreenImage) image).getBitmap();
		canvas.drawBitmap(bitmap, x, y, null);
	}

	@Override
	public void drawImage(OffscreenImage image, int dx, int dy, int sx, int sy,
			int width, int height) {
		Bitmap bitmap = ((AndroidOffscreenImage) image).getBitmap();
		
		dst.set(dx,dy,dx+width,dy+height);
		src.set(sx,sy,sx+width,sy+height);
		
		canvas.drawBitmap(bitmap, src, dst, null);
	}

	@Override
	public void drawRect(int x, int y, int width, int height) {
		paint.setStyle(Style.STROKE);
		canvas.drawRect(x,y,x+width,y+height,paint);
	}

	@Override
	public void drawString(String str, int x, int y) {
		paint.setStyle(Style.FILL);
		paint.setColor(color);
		paint.setAntiAlias(true);
		canvas.drawText(str, x, y, paint);
		paint.setAntiAlias(false);
	}

	@Override
	public void fillOval(int x, int y, int width, int height) {
		paint.setStyle(Style.FILL);
		rect.set(x,y,x+width,y+height);
		canvas.drawOval(rect, paint);
	}

	@Override
	public void fillRect(int x, int y, int width, int height) {
		paint.setStyle(Style.FILL);
		canvas.drawRect(x,y,x+width,y+height,paint);
	}

	@Override
	public Typeface getFont() {
		return font;
	}

	@Override
	public void setAntialias(boolean anti) {
		paint.setAntiAlias(anti);
	}

	@Override
	public void setColor(int col) {
		int a = col >> 24;
		if (a == 0) {
			col = col | 0xFF000000;
		}
		
		this.color = col;
		paint.setColor(col);
	}

	@Override
	public void setFont(Typeface face) {
		this.font = face;
		paint.setTypeface(((AndroidTypeface) face).getAndroid());
		paint.setTextSize(((AndroidTypeface) face).getSize());
	}

	@Override
	public int stringWidth(String str) {
		paint.getTextBounds(str, 0, str.length(), src);
		return src.width();
	}

	@Override
	public void translate(int x, int y) {
		canvas.translate(x, y);
	}

}
