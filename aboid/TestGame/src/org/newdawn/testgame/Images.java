package org.newdawn.testgame;

import java.io.IOException;

import org.newdawn.game.GameContext;
import org.newdawn.game.OffscreenImage;
import org.newdawn.game.Typeface;

public class Images {
	public static OffscreenImage star;
	public static Typeface font;
	
	public static void init(GameContext context) throws IOException {
		star = context.loadImage("assets/res/star.png", OffscreenImage.BITMASK);
		font = context.loadTypeface("assets/res/font.ttf").derive(20);
	}
}
