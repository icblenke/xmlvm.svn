
package org.xmlvm.iphone.internal;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;



public class FileImageLoader
    implements ImageLoader
{

    public Image loadImage(String imageName)
    {
    	Image toRet;
    	toRet = Toolkit.getDefaultToolkit().getImage(imageName);
    	return toRet;
    	
    }

}
