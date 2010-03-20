package org.newdawn.testgame.iphone;

import org.newdawn.game.iphone.IPhoneMain;
import org.newdawn.testgame.TestGame;
import org.xmlvm.iphone.UIApplication;

public class TestGameIPhone extends IPhoneMain {

	@Override
	public void applicationDidFinishLaunching(UIApplication application) {   
		setGame(new TestGame());
		
		super.applicationDidFinishLaunching(application);
	}
	
	public static void main(String[] argv) {
		try {
			UIApplication.main(argv, TestGameIPhone.class);
		} catch (Throwable e) {
			System.out.println(e.toString());
			System.out.println(e.getMessage());
		}
	}
}