package org.newdawn.game.android;

import org.newdawn.game.GraphicsContext;
import org.newdawn.game.OffscreenImage;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class AndroidOffscreenImage implements OffscreenImage {
	private Bitmap bitmap;
	private GraphicsContext context;
	
	public AndroidOffscreenImage(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
	
	Bitmap getBitmap() {
		return bitmap;
	}

	@Override
	public int getHeight() {
		return bitmap.getHeight();
	}

	@Override
	public int getWidth() {
		return bitmap.getWidth();
	}

}
