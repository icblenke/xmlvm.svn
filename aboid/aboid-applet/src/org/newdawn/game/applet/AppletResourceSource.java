package org.newdawn.game.applet;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.newdawn.util.AltSource;
import org.newdawn.util.ResourceLoadListener;
import org.newdawn.util.ResourceSource;

public class AppletResourceSource implements ResourceSource {
	private int alts;
	private byte[][] data;
	private int totalRead;
	private ArrayList sources = new ArrayList();
	
	public void addAltSource(AltSource source) {
		sources.add(source);
	} 
	
	public AltSource getNextAltSource() {
		if (sources.size() == 0) {
			return null;
		}
		
		return (AltSource) sources.remove(0);
	}
	
	public void initAltSource(URL url, ResourceLoadListener listener) {
		if (data == null) {
			data = new byte[10][];
		}
		
		try {
			URLConnection connection;
			int length;
			
			try {
				connection = url.openConnection();
				length = connection.getContentLength();
			} catch (Throwable e) {
				// fix an issue with the new plugin where caching doesn't work correctly
				connection = url.openConnection();
				connection.setUseCaches(false);
				length = connection.getContentLength();
			}
			
			data[alts] = new byte[length];
			
			BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
			while (length > 0) {
				int len = in.read(data[alts],data[alts].length-length,length);
				length -= len;
				totalRead += len;
				
				listener.chunkLoaded();
			}
			
			in.close();
			alts++;
		} catch (IOException e) {
			data[alts] = null;
			System.out.println("Unable to locate: "+url);
		}
		
	}
	
	public float getLoadProgress() {
		if (data == null) {
			return 0;
		}
		
		if (data[alts] == null) {
			return 0;
		}
		
		float result =  totalRead / (float) data[alts].length;
		return Math.min(1.0f, result);
	}

	private InputStream locateResourceInJar(String ref) {
		if (data == null) {
			return null;
		}
		
		for (int i=0;i<data.length;i++) {
			if (data[i] != null) {
				InputStream in = locateResourceInJar(ref, i);
				if (in != null) {
					return in;
				}
			}
		}
		
		return null;
	}
	
	private InputStream locateResourceInJar(String ref, int index) {
		if (data == null) {
			System.out.println("No resource data JAR loaded when locating: "+ref);
			return null;
		}
		
		try {
			JarInputStream in = new JarInputStream(new ByteArrayInputStream(data[index]));
			JarEntry entry = null;
			while ((entry = in.getNextJarEntry()) != null) {
				if (entry.getName().equals(ref)) {
					return in;
				}
			}
			in.close();
		} catch (IOException e) {
			return null;
		}
		
		return null;
	}
	
	public InputStream getResource(String ref) {
		InputStream in = locateResourceInJar(ref);
		
		if (in == null) {
			in = AppletResourceSource.class.getClassLoader().getResourceAsStream(ref);
			
			if (in == null) {
				throw new RuntimeException("Resource: "+ref+" no found");
			}
		}
		
		return new BufferedInputStream(in);
	}
}
