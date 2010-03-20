package org.newdawn.game.iphone;

import org.newdawn.game.Game;
import org.xmlvm.iphone.UIApplication;
import org.xmlvm.iphone.UIScreen;
import org.xmlvm.iphone.UIWindow;

public class IPhoneMain extends UIApplication { //implements UIAccelerometerDelegate {
	private Game game;
	private UIWindow window;
	private GameView mainView;
	//private UIAccelerometer accel;
	
	public void setGame(Game g) {
		game = g;
	}

	@Override
	public void applicationDidFinishLaunching(UIApplication application) {     
		this.setStatusBarHidden(true);

	    UIScreen screen = UIScreen.mainScreen();
	    window = new UIWindow(screen.applicationFrame());
	
	    mainView = new GameView(game, screen.applicationFrame());
	
	    window.addSubview(mainView);
	    window.makeKeyAndVisible();
	    
//	    accel = UIAccelerometer.getSharedAccelerometer();
//	    accel.setUpdateInterval(1.0/40);
//	    accel.setDelegate(this);
	}

//	@Override
//	public void accelerometerDidAccelerate(UIAccelerometer accel, UIAcceleration delta) {
//	}
}
