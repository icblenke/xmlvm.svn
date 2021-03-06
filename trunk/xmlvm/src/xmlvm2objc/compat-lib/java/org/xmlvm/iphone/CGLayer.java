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

package org.xmlvm.iphone;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class CGLayer {
    BufferedImage image;

    public static CGLayer createWithContext(CGContext context, CGSize size) {
        CGLayer layer = new CGLayer();
        layer.image = new BufferedImage((int) size.width, (int) size.height,
                BufferedImage.TYPE_INT_ARGB);

        return layer;
    }

    public CGContext getContext() {
        return new CGContext((Graphics2D) image.getGraphics());
    }

    public CGSize getSize() {
        return new CGSize(image.getWidth(), image.getHeight());
    }
}
