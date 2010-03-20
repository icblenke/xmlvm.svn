package org.newdawn.game.android;

import org.newdawn.game.GraphicsContext;
import org.newdawn.game.Typeface;

public class AndroidTypeface implements Typeface {
	private float size;
	private String name;
	private android.graphics.Typeface face;
	
	public AndroidTypeface(android.graphics.Typeface face, String name, float size) {
		this.name = name;
		this.size = size;
		this.face = face;
	}
	
	android.graphics.Typeface getAndroid() {
		return face;
	}
	
	public AndroidTypeface derive(int size) {
		return new AndroidTypeface(face, name, size);
	}
	
	public float getSize() {
		return size;
	}
	
	public String getName() {
		return name;
	}

	public int getWidth(GraphicsContext context, String str) {
		Typeface temp = context.getFont();
		
		context.setFont(this);
		int width = context.stringWidth(str);
		context.setFont(temp);
		
		return width;
	}

}
