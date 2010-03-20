package org.newdawn.game.android;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.newdawn.util.AltSource;
import org.newdawn.util.ResourceLoadListener;
import org.newdawn.util.ResourceSource;

import android.content.res.AssetManager;

public class AndroidResourceSource implements ResourceSource {
	private AssetManager assets;
	
	public AndroidResourceSource(AssetManager assets) {
		this.assets = assets;
	}
	
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
		ref = ref.substring("assets/".length());
		
		try {
			return assets.open(ref);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void initAltSource(URL url, ResourceLoadListener listener) {
	}

}
