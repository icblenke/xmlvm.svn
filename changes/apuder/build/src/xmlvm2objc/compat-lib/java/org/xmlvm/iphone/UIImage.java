
package org.xmlvm.iphone;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import org.xmlvm.iphone.internal.ImageLoader;
import org.xmlvm.iphone.internal.Simulator;



public class UIImage
{

    public Image image;



    private UIImage(String filename)
    {
        ImageLoader loader = Simulator.getImageLoader();
        image = loader.loadImage(filename);
    }



    public static UIImage imageAtPath(String filename)
    {
    	File fi = new File(filename);
    	if(!fi.exists())
    	{
    		return new UIImage("./var/iphone/" + filename);
    	}
    	else
    	{
    		return new UIImage(filename);
    	}
    }



    public void draw1PartImageInRect(CGRect position)
    {
        CGContext.theContext.graphicsContext.drawImage(image,
                (int) position.origin.x, (int) position.origin.y,
                (int) position.size.width, (int) position.size.height,
                Simulator.getDisplay());
    }
}
