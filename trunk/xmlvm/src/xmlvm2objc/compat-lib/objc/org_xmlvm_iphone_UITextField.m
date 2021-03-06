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

#import "xmlvm.h"
#import "org_xmlvm_iphone_UITextField.h"


// UITextField
//----------------------------------------------------------------------------
@implementation UITextField (cat_org_xmlvm_iphone_UITextField);

- (void) __init_org_xmlvm_iphone_UITextField__
{
	[self initWithFrame: CGRectZero];
}

- (void) __init_org_xmlvm_iphone_UITextField___org_xmlvm_iphone_CGRect :(org_xmlvm_iphone_CGRect*)n1
{
	[self initWithFrame: [n1 getCGRect]];
}


- (void) setText___java_lang_String :(NSString*)n1
{
    [self setText: n1];
}

- (NSString*) getText__
{
    return [[self text] retain];
}

- (void) setTextColor___org_xmlvm_iphone_UIColor: (org_xmlvm_iphone_UIColor*) color
{
	[self setTextColor: color];
}

- (void) setBorderStyle___int :(int) style
{
	UITextBorderStyle s;
	switch (style) {
		case 0:
			s = UITextBorderStyleNone;
			break;
		case 1:
			s = UITextBorderStyleLine;
			break;
		case 2:
			s = UITextBorderStyleBezel;
			break;
		case 3:
			s = UITextBorderStyleRoundedRect;
			break;
	}
	self.borderStyle = s;
}

- (void) setPlaceholder___java_lang_String: (java_lang_String*) p
{
	self.placeholder = p;
}

- (org_xmlvm_iphone_UIFont*) getFont__
{
	return [self.font retain];
}

@end
