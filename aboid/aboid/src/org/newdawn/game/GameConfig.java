package org.newdawn.game;

import java.net.URL;

public interface GameConfig {

	public String getParameter(String name);
	
	public URL getCodeBase();
}
