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

package org.xmlvm.demo.afireworks;

public class Const {
	public final static int BOMB_COUNT = 6;
	public final static int SPARKS_PER_BOMB = 12;

	/** The delay in milliseconds in between frames. */
	public final static int UPDATE_DELAY = 30;

	final static int IMAGE_SIZE = 15;

	final static float MAX2V = 70.0f;
	final static float T = 0.3f;
	final static float G = 9.81f;
	final static float DV = T * G;
}
