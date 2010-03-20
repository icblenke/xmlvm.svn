package org.newdawn.game.iphone;

import org.newdawn.game.OffscreenImage;
import org.xmlvm.iphone.UIImage;

public class IPhoneOffscreenImage implements OffscreenImage {
	private UIImage image;
	
	public IPhoneOffscreenImage(UIImage image) {
		this.image = image;
	}
	
	public UIImage getUIImage() {
		return image;
	}

	@Override
	public int getHeight() {
		return (int) image.getSize().height;
	}

	@Override
	public int getWidth() {
		return (int) image.getSize().width;
	}

}
