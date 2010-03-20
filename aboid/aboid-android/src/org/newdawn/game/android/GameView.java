package org.newdawn.game.android;

import java.io.IOException;
import java.net.URL;

import org.newdawn.game.Game;
import org.newdawn.game.GameConfig;
import org.newdawn.game.GameContext;
import org.newdawn.game.GameState;
import org.newdawn.game.GraphicsContext;
import org.newdawn.game.OffscreenImage;
import org.newdawn.game.Typeface;
import org.newdawn.util.ResourceLoader;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View implements GameContext, GameConfig {
	public static final int FPS = 30;
	public static final int MOVE_DELAY = 1000 / FPS;
		
    private RefreshHandler redrawHandler = new RefreshHandler();
    private boolean started = false;
    private long lastMove;
    
    private Game game;
    private GameState gameState;
    private GraphicsContext graphics;
    
    private float lastX;
    private float lastY;
    
    private AssetManager assets;
    
	public GameView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public GameView(Context context) {
		super(context);
	}

	public void setAssets(AssetManager assets) {
		this.assets = assets;
		ResourceLoader.setResourceSource(new AndroidResourceSource(assets));
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public void start() {
		if (!started) {
			started = true;
			
			try {
				game.preload(this);
				game.init(this);
				
				GameState[] states = game.getStates(this);
				for (int i=0;i<states.length;i++) {
					states[i].init(this);
				}
				
				gameState = game.getInitialState(this);
				gameState.enter(this);
				
				redrawHandler.sleep(MOVE_DELAY);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		if (graphics == null) {
			graphics = new AndroidGraphicsContext(canvas);
		}
		
		canvas.save();
		gameState.render(this, graphics);
		canvas.restore();
	}

	public void update() {
        long now = System.currentTimeMillis();

        if (now - lastMove > MOVE_DELAY) {
        	
    		gameState.update(this);
        	lastMove = now;
        	invalidate();
        }
        
        redrawHandler.sleep(MOVE_DELAY);
	}

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            	gameState.mousePressed((int) x,(int) y,1);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
            	gameState.mouseDragged((int) lastX, (int) lastY, (int) x, (int) y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
            	gameState.mouseReleased((int) x,(int) y,1);
                invalidate();
                break;
        }
        
    	lastX = x;
    	lastY = y;
        return true;
    }
    
	class RefreshHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            update();
        }

        public void sleep(long delayMillis) {
        	this.removeMessages(0);
            sendMessageDelayed(obtainMessage(0), delayMillis);
        }
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
		Bitmap bitmap = BitmapFactory.decodeStream(ResourceLoader.getResource(ref));
		
		return new AndroidOffscreenImage(bitmap);
	}

	@Override
	public Typeface loadTypeface(String ref) throws IOException {
		ref = ref.substring("assets/".length());
		android.graphics.Typeface face = android.graphics.Typeface.createFromAsset(assets, ref);
		
		return new AndroidTypeface(face,ref,16);
	}

	@Override
	public URL getCodeBase() {
		return null;
	}

	@Override
	public String getParameter(String name) {
		return "";
	};
}
