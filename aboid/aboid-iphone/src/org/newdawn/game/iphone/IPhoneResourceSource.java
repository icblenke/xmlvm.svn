package org.newdawn.game.iphone;

import java.io.InputStream;
import java.net.URL;

import org.newdawn.util.AltSource;
import org.newdawn.util.ResourceLoadListener;
import org.newdawn.util.ResourceSource;

public class IPhoneResourceSource implements ResourceSource {

	@Override
	public void addAltSource(AltSource source) {
	}

	@Override
	public float getLoadProgress() {
		return 1.0f;
	}

	@Override
	public AltSource getNextAltSource() {
		return null;
	}

	@Override
	public InputStream getResource(String ref) {
		return null;
	}

	@Override
	public void initAltSource(URL url, ResourceLoadListener listener) {
	}

}
