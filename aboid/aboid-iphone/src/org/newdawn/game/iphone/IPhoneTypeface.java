package org.newdawn.game.iphone;

import org.newdawn.game.GraphicsContext;
import org.newdawn.game.Typeface;
import org.xmlvm.iphone.CGContext;
import org.xmlvm.iphone.CGFont;
import org.xmlvm.iphone.CGPoint;

public class IPhoneTypeface implements Typeface {
	private CGFont font;
	private String name;
	private int size;
	
	public IPhoneTypeface(String name, CGFont font, int size) {
		this.size = size;
		this.name = name;
		this.font = font;
	}
	
	public int getSize() {
		return size;
	}
	
	public CGFont getFont() {
		return font;
	}
	
	@Override
	public Typeface derive(int size) {
		return new IPhoneTypeface(name, font, size);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getWidth(GraphicsContext context, String str) {
		IPhoneGraphicsContext c = (IPhoneGraphicsContext) context;
		CGContext ctx = c.getContext();
		
		CGPoint start = ctx.getTextPosition();
		ctx.setTextDrawingMode(CGContext.kCGTextInvisible);
		ctx.showText(str);
		CGPoint end = ctx.getTextPosition();
		ctx.setTextDrawingMode(CGContext.kCGTextFill);
		
		return (int) (end.x - start.x);
	}

}
