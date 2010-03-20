package org.newdawn.util;

import java.io.InputStream;
import java.net.URL;

public interface ResourceSource {

	public void addAltSource(AltSource source);
	
	public AltSource getNextAltSource();
	
	public void initAltSource(URL url, ResourceLoadListener listener);
	
	public float getLoadProgress();
	
	public InputStream getResource(String ref);
}