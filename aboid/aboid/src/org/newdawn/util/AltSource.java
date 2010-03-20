package org.newdawn.util;

import java.net.URL;

public class AltSource {
	private String name;
	private URL location;
	
	public AltSource(String name, URL url) {
		this.name = name;
		this.location = url;
	}
	
	public String getName() {
		return name;
	}
	
	public URL getLocation() {
		return location;
	}
}
