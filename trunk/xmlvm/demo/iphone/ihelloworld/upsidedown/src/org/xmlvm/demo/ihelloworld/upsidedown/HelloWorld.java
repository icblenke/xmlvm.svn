/*
 * Copyright (c) 2004-2009 XMLVM --- An XML-based Programming Language
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 675 Mass
 * Ave, Cambridge, MA 02139, USA.
 * 
 * For more information, visit the XMLVM Home Page at http://www.xmlvm.org
 */

package org.xmlvm.demo.ihelloworld.upsidedown;

import org.xmlvm.iphone.*;

public class HelloWorld extends UIApplication {

    @Override
    public void applicationDidFinishLaunching(UIApplication app) {
        this.setStatusBarOrientation(UIInterfaceOrientation.PortraitUpsideDown);
        UIScreen screen = UIScreen.mainScreen();
        CGRect rect = screen.getApplicationFrame();
        UIWindow window = new UIWindow(rect);
        CGAffineTransform trans = CGAffineTransform.makeRotation((float) ((Math.PI / 180) * 180));
        window.setTransform(trans);

        rect.origin.x = rect.origin.y = 0;
        UIView mainView = new UIView(rect);
        window.addSubview(mainView);

        UILabel title = new UILabel(rect);
        title.setText("Hello World!");
        title.setTextAlignment(UITextAlignment.Center);
        mainView.addSubview(title);

        window.makeKeyAndVisible();
    }

    public static void main(String[] args) {
        UIApplication.main(args, HelloWorld.class);
    }

}
