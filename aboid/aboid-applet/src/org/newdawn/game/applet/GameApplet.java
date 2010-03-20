package org.newdawn.game.applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.StringTokenizer;

import org.newdawn.game.Game;
import org.newdawn.game.GameConfig;
import org.newdawn.game.java2d.GamePanel;
import org.newdawn.util.AltSource;
import org.newdawn.util.ResourceLoadListener;
import org.newdawn.util.ResourceLoader;

public class GameApplet extends Applet implements GameConfig {
	private static final long serialVersionUID = -1502584013296614420L;
	
	private GamePanel panel;
	private boolean loaded = false;
	private Font font;
	private Exception failure;
	private String[] text;
	private boolean started = false;
	private BufferedImage backBuffer;
	private Game game;
	private String loadingMessage = "";
	
	public void init() {
		ResourceLoader.setResourceSource(new AppletResourceSource());
		
		try {
			game = (Game) Class.forName(getParameter("gameClass")).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
		setBackground(Color.black);
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("res/squealer.ttf"));
		} catch (Exception e) {
			System.out.println("Failed to load core font.");
		} 
		
		try {
			game.preload(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update(Graphics g) {
		if (loaded) {
			super.update(g);
			return;
		}
		
		paint(g);
	}
	
	public void paint(Graphics g1d) {
		if (loaded) {
			super.paint(g1d);
			return;
		}
		
		if (!started) {
			try {
				startLoad();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		
		if (backBuffer == null) {
			backBuffer = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_ARGB);
		}
		
		Graphics2D g = (Graphics2D) backBuffer.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,getWidth(),getHeight());
		
		g.setColor(Color.white);
		if (failure != null) { 
			g.setFont(g.getFont().deriveFont(16.0f));
			g.drawString("Loading failed: "+failure.getMessage(), 10, 50);
			for (int i=0;i<text.length;i++) {
				g.drawString(text[i], 20, 80+(i*20));
			}
		} else {
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			if (font != null) {
				g.setFont(font.deriveFont(24.0f));
			}
			
			g.setColor(Color.white);
			g.drawString(loadingMessage, (getWidth()-244)/2, getHeight()/2);
			g.drawRect((getWidth()-244)/2,(getHeight()/2)+10,244,20);
			g.setColor(Color.lightGray);
			g.fillRect(((getWidth()-244)/2)+1,(getHeight()/2)+11,(int) (241*ResourceLoader.getLoadProgress()),17);
		}
		
		g1d.drawImage(backBuffer, 0, 0, null);
	}
	
	public void startLoad() {
		if (started) {
			return;
		}
		started = true;
		
		Thread thread = new Thread() {
			public void run() {
				try {
					if (panel == null) {
						try {				
							AltSource nextSource = ResourceLoader.getNextAltSource();
							while (nextSource != null) {
								loadingMessage = "Loading "+nextSource.getName()+"...";
								ResourceLoader.initAltSource(nextSource.getLocation(), new ResourceLoadListener() {
									public void chunkLoaded() {
										repaint(0);
										try { Thread.sleep(10); } catch (Exception e) {};
									}
								});
							}
							
							panel = getPanelImpl();
							panel.setBounds(getBounds());
							setLayout(null);
							add(panel);
							
							panel.gameInit();
						} catch (Exception e) {
							e.printStackTrace();
							recordFailure(e);
						}
					}
					
					try {
						panel.gameLoop();
					} catch (Exception e) {
						e.printStackTrace();
						recordFailure(e);
					}
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
	}

	private GamePanel getPanelImpl() {
		return new GamePanel(game);
	}
	
	public void stop() {
		if (panel != null) {
			panel.end();
		}
	}
	
	private void recordFailure(Exception e) {
		remove(panel);
		panel = null;
		loaded = false;
		failure = e;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		e.printStackTrace(new PrintStream(bout));
		StringTokenizer tokens = new StringTokenizer(new String(bout.toByteArray()), "\r\n");
		 
		text = new String[tokens.countTokens()];
		for (int i=0;i<text.length;i++) {
			text[i] = tokens.nextToken();
		}
		repaint(0);
		throw new RuntimeException(e);
	}
}
