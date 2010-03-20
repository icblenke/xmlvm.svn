package org.newdawn.game.iphone;

import java.io.IOException;
import java.util.Set;

import org.newdawn.game.Game;
import org.newdawn.game.GameContext;
import org.newdawn.game.GameState;
import org.newdawn.game.OffscreenImage;
import org.newdawn.game.Typeface;
import org.xmlvm.iphone.CGDataProvider;
import org.xmlvm.iphone.CGFont;
import org.xmlvm.iphone.CGRect;
import org.xmlvm.iphone.NSTimer;
import org.xmlvm.iphone.UIEvent;
import org.xmlvm.iphone.UIImage;
import org.xmlvm.iphone.UITouch;
import org.xmlvm.iphone.UIView;

public class GameView extends UIView implements GameContext {
	private NSTimer timer;
	private Game game;
	private GameState gameState;
	private IPhoneGraphicsContext graphics;
	private int oldx;
	private int oldy;
	private boolean graphicsCreated;
	
    public GameView(Game game, CGRect windowRect) {
        super(windowRect);       
        
        this.game = game;
        
        initGame();
        setNeedsDisplay();
        initTimer();
        
	}    
    
    @Override
	public void drawRect(CGRect rect) {
    	try {
	    	if (!graphicsCreated) {
	    		graphicsCreated = true;
	    		graphics = new IPhoneGraphicsContext();
	    	}
	    	graphics.refresh();
	    	gameState.render(this, graphics);
    	} catch (Throwable e) {
			System.out.println(e.toString());
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void keyTyped(char key) {
	}

	@Override
	public void touchesBegan(Set<UITouch> touches, UIEvent event) {
        UITouch touch = touches.iterator().next();
        int x = (int) touch.locationInView(this).x;
        int y = (int) touch.locationInView(this).y;
        
        gameState.mousePressed(x, y, 1);
        oldx = x;
        oldy = y;
	}

	@Override
	public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        UITouch touch = touches.iterator().next();
        int x = (int) touch.locationInView(this).x;
        int y = (int) touch.locationInView(this).y;

        gameState.mouseReleased(x, y, 1);
        oldx = x;
        oldy = y;
	}

	@Override
	public void touchesMoved(Set<UITouch> touches, UIEvent event) {
        UITouch touch = touches.iterator().next();
        int x = (int) touch.locationInView(this).x;
        int y = (int) touch.locationInView(this).y;
        
        gameState.mouseDragged(oldx, oldy, x, y);
        oldx = x;
        oldy = y;
	}

	public void initGame() {
		try {
	    	game.init(this);
			GameState[] states = game.getStates(this);
			for (int i=0;i<states.length;i++) {
				states[i].init(this);
			}
			
	    	gameState = game.getInitialState(this);
	    	gameState.enter(this);
		} catch (Throwable e) {
			System.out.println(e.toString());
			System.out.println(e.getMessage());
		}
    }
    
    private void initTimer() {
        timer = new NSTimer(0.05f, this, "triggered", null, true);
    }
    
    public void triggered(NSTimer timer) {
    	try {
	    	gameState.update(this);
		} catch (Throwable e) {
			System.out.println(e.toString());
			System.out.println(e.getMessage());
		}
		
        setNeedsDisplay();
    }

	@Override
	public void changeState(GameState state) {
		if (gameState != null) {
			gameState.leave(this);
		}
		
		this.gameState = state;
		
		if (gameState != null) {
			gameState.enter(this);
		}
	}
	
	@Override
	public OffscreenImage loadImage(String ref, int trans) throws IOException {
		return new IPhoneOffscreenImage(UIImage.imageAtPath(ref));
	}

	@Override
	public Typeface loadTypeface(String typeface) throws IOException {
		return new IPhoneTypeface(typeface, CGFont.createFromDataProider(CGDataProvider.providerToPath(typeface)), 16);
	}
}
