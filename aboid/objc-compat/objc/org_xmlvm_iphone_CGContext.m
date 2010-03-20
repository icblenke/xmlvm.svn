#import "org_xmlvm_iphone_CGContext.h"

extern void CGFontGetGlyphsForUnichars(CGFontRef, const unichar[], const CGGlyph[], size_t);

// CGContext
//----------------------------------------------------------------------------
@implementation org_xmlvm_iphone_CGContext;

+ (org_xmlvm_iphone_CGContext*) UICurrentContext
{
	
    org_xmlvm_iphone_CGContext* c = [[org_xmlvm_iphone_CGContext alloc] init];
	c->context = UIGraphicsGetCurrentContext();
    return c;
}
    

- (void) setFillColor___float_ARRAYTYPE: (NSMutableArray*) color
{
    float c[4] = { [[color objectAtIndex:0] floatValue],
                   [[color objectAtIndex:1] floatValue],
                   [[color objectAtIndex:2] floatValue],
                   [[color objectAtIndex:3] floatValue] };
    CGContextSetFillColor(context, c);
}

- (void) setStrokeColor___float_ARRAYTYPE: (NSMutableArray*) color
{
    float c[4] = { [[color objectAtIndex:0] floatValue],
                   [[color objectAtIndex:1] floatValue],
                   [[color objectAtIndex:2] floatValue],
                   [[color objectAtIndex:3] floatValue] };
    CGContextSetStrokeColor(context, c);
}

- (void) fillRect___org_xmlvm_iphone_CGRect: (org_xmlvm_iphone_CGRect*)rect
{
    CGRect r = [rect getCGRect];
    CGContextFillRect(context, r);
}

- (void) strokeRect___org_xmlvm_iphone_CGRect: (org_xmlvm_iphone_CGRect*)rect
{
    CGRect r = [rect getCGRect];
    CGContextStrokeRect(context, r);
}

- (void) fillEllipseInRect___org_xmlvm_iphone_CGRect: (org_xmlvm_iphone_CGRect*)rect
{
    CGRect r = [rect getCGRect];
    CGContextFillEllipseInRect(context, r);
}

- (void) clipToRect___org_xmlvm_iphone_CGRect: (org_xmlvm_iphone_CGRect*)rect
{
    CGRect r = [rect getCGRect];
    CGContextClipToRect(context, r);
}

- (void) translate___float_float :(float)x :(float)y
{
	CGContextTranslateCTM(context, x, y);
}

- (void) setAlpha___float :(float)alpha
{
	CGContextSetAlpha(context, alpha);
}

- (void) setFont___org_xmlvm_iphone_CGFont: (org_xmlvm_iphone_CGFont*)font
{
	localFont = font->font;
	CGContextSetFont(context, font->font);
	CGContextSetTextMatrix(context, CGAffineTransformMakeScale(1,-1));
}

- (void) setFontSize___float :(float)size
{
	localSize = size;
	CGContextSetFontSize(context, size);
}

- (void) showTextAtPoint___float_float_java_lang_String: (float)x: (float)y: (NSString*)text
{
	int textLength = [text length];
	unichar chars[textLength];
	CGGlyph textToPrint[textLength];
	[text getCharacters:chars range:NSMakeRange(0,textLength)];

	CGFontGetGlyphsForUnichars(localFont, chars, textToPrint, textLength);
	CGContextShowGlyphsAtPoint(context, x, y, textToPrint, textLength);
}

- (void) showText___java_lang_String: (NSString*)text
{
	int textLength = [text length];
	unichar chars[textLength];
	CGGlyph textToPrint[textLength];
	[text getCharacters:chars range:NSMakeRange(0,textLength)];

	CGFontGetGlyphsForUnichars(localFont, chars, textToPrint, textLength);
	CGContextShowGlyphs(context, textToPrint, textLength);
}

- (org_xmlvm_iphone_CGPoint*) getTextPosition
{
	CGPoint pt = CGContextGetTextPosition(context);
	org_xmlvm_iphone_CGPoint* retVal = [[[org_xmlvm_iphone_CGPoint alloc] init] autorelease];
	retVal->x = pt.x;
	retVal->y = pt.y;
	
	return retVal;
}

- (org_xmlvm_iphone_CGRect*)getClip;
{
	CGRect rect = CGContextGetClipBoundingBox(context);
	org_xmlvm_iphone_CGRect* retVal = [[[org_xmlvm_iphone_CGRect alloc] init] autorelease];
	retVal->origin->x = rect.origin.x;
	retVal->origin->y = rect.origin.y;
	retVal->size->width = rect.size.width;
	retVal->size->height = rect.size.height;
	
	return retVal;
}

- (void) setTextDrawingMode___int :(int)mode
{
	if (mode == 1) {
		CGContextSetTextDrawingMode(context, kCGTextInvisible);
	} else {
		CGContextSetTextDrawingMode(context, kCGTextFill);
	}
}

- (void) storeState
{
	CGContextSaveGState(context);
}

- (void) restoreState
{
	CGContextRestoreGState(context);
}

@end