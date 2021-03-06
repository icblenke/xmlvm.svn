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


/** @author teras */

#include "org_xmlvm_iphone_UISlider.h"

// UISlider
//----------------------------------------------------------------------------

@implementation UISlider(cat_org_xmlvm_iphone_UISlider)

- (void) __init_org_xmlvm_iphone_UISlider {
    [self initWithFrame : CGRectZero];
}

-(void) __init_org_xmlvm_iphone_UISlider___org_xmlvm_iphone_CGRect : (org_xmlvm_iphone_CGRect*) r {
    CGRect rect = [r getCGRect];
    [self initWithFrame : rect];
}

-(float) getValue__ {
    return [self value];
}

-(float) getMinimumValue__ {
    return [self minimumValue];
}

-(float) getMaximumValue__ {
    return [self maximumValue];
}

-(void) setMinimumValue___float : (float) value {
    [self setMinimumValue : value];
}

-(void) setMaximumValue___float : (float) value {
    [self setMaximumValue : value];
}

-(void) setValue___float : (float) value {
    [self setValue : value];
}

@end
