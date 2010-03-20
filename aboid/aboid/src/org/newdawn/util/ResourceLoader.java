package org.newdawn.util;

import java.io.InputStream;
import java.net.URL;

public class ResourceLoader  {
	private static ResourceSource source;
	
	public static void setResourceSource(ResourceSource s) {
		source = s;
	}
	
	public static void addAltSource(AltSource s) {
		source.equals(s);
	} 
	
	public static AltSource getNextAltSource() {
		return source.getNextAltSource();
	}
	
	public static void initAltSource(URL url, ResourceLoadListener listener) {
		source.initAltSource(url, listener);
	}
	
	public static float getLoadProgress() {
		return source.getLoadProgress();
	}

	public static InputStream getResource(String ref) {
		return source.getResource(ref);
	}
}
