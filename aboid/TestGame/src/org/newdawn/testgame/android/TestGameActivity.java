package org.newdawn.testgame.android;

import org.newdawn.game.android.GameView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

// TODO: You need you generated R class to be in the same package
// this should be generated by the android tool set.
public class TestGameActivity extends Activity {
	private GameView gameView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                			 WindowManager.LayoutParams.FLAG_FULLSCREEN); 
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        //setContentView(R.layout.main);

        //gameView = (GameView) findViewById(R.id.gameview);
        gameView.setAssets(getAssets());
        //gameView.setGame(new TestGame());
        gameView.start();
    }
}