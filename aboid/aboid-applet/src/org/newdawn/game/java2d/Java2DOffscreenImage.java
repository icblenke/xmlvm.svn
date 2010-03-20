package org.newdawn.game.java2d;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;

import org.newdawn.game.GraphicsContext;
import org.newdawn.game.OffscreenImage;

public class Java2DOffscreenImage implements OffscreenImage {
	private BufferedImage image;

	public Java2DOffscreenImage(BufferedImage image) {
		this.image = image;
	}
	
	public Java2DOffscreenImage(int width, int height, int trans) {
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		image = gc.createCompatibleImage(width, height, trans);
	}

	public BufferedImage getImage() {
		return image;
	}

	public int getHeight() {
		return image.getHeight();
	}

	public int getWidth() {
		return image.getWidth();
	}
}
