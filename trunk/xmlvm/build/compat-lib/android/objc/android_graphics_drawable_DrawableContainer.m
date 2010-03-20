#import "android_graphics_Rect.h"
#import "java_lang_Object.h"
#import "android_graphics_Canvas.h"
#import "android_graphics_drawable_DrawableContainer_DrawableContainerState.h"

// Automatically generated by xmlvm2obj. Do not edit!


#import "android_graphics_drawable_DrawableContainer.h"


@implementation android_graphics_drawable_DrawableContainer;

+ (void) initialize
{
    if (strcmp(class_getName(self), "android_graphics_drawable_DrawableContainer") == 0) {
    }
}

- (id) init
{
    if (self = [super init]) {
        currentDrawable_android_graphics_drawable_Drawable = (id) [NSNull null];
        drawableContainerState_android_graphics_drawable_DrawableContainer_DrawableContainerState = (id) [NSNull null];
    }
    return self;
}

- (void) dealloc
{
    [currentDrawable_android_graphics_drawable_Drawable release];
    [drawableContainerState_android_graphics_drawable_DrawableContainer_DrawableContainerState release];
    [super dealloc];
}

- (void) __init_android_graphics_drawable_DrawableContainer__
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r1.o = self;
    [((android_graphics_drawable_Drawable*) _r1.o) __init_android_graphics_drawable_Drawable__];
    _r0.i = -1;
    ((android_graphics_drawable_DrawableContainer*) _r1.o)->currentIndex_int = _r0.i;
    _r0.o = [NSNull null];
    [_r0.o retain];
    [((android_graphics_drawable_DrawableContainer*) _r1.o)->currentDrawable_android_graphics_drawable_Drawable release];
    ((android_graphics_drawable_DrawableContainer*) _r1.o)->currentDrawable_android_graphics_drawable_Drawable = _r0.o;
    [_pool release];
    return;
}


- (void) setConstantState___android_graphics_drawable_DrawableContainer_DrawableContainerState :(android_graphics_drawable_DrawableContainer_DrawableContainerState*)n1
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r0.o = self;
    _r1.o = n1;
    [_r1.o retain];
    [((android_graphics_drawable_DrawableContainer*) _r0.o)->drawableContainerState_android_graphics_drawable_DrawableContainer_DrawableContainerState release];
    ((android_graphics_drawable_DrawableContainer*) _r0.o)->drawableContainerState_android_graphics_drawable_DrawableContainer_DrawableContainerState = _r1.o;
    [_pool release];
    return;
}


- (int) getIntrinsicWidth__
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r1.o = self;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->drawableContainerState_android_graphics_drawable_DrawableContainer_DrawableContainerState retain] autorelease];
    _r0.i = [((android_graphics_drawable_DrawableContainer_DrawableContainerState*) _r0.o) isConstantSize__];
    if (_r0.i == 0) goto label15;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->drawableContainerState_android_graphics_drawable_DrawableContainer_DrawableContainerState retain] autorelease];
    _r0.i = [((android_graphics_drawable_DrawableContainer_DrawableContainerState*) _r0.o) getConstantWidth__];
    label14:;
    [_pool release];
    return _r0.i;
    label15:;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    if (_r0.o == [NSNull null]) goto label26;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    _r0.i = [((android_graphics_drawable_Drawable*) _r0.o) getIntrinsicWidth__];
    goto label14;
    label26:;
    _r0.i = -1;
    goto label14;
}


- (int) getIntrinsicHeight__
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r1.o = self;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->drawableContainerState_android_graphics_drawable_DrawableContainer_DrawableContainerState retain] autorelease];
    _r0.i = [((android_graphics_drawable_DrawableContainer_DrawableContainerState*) _r0.o) isConstantSize__];
    if (_r0.i == 0) goto label15;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->drawableContainerState_android_graphics_drawable_DrawableContainer_DrawableContainerState retain] autorelease];
    _r0.i = [((android_graphics_drawable_DrawableContainer_DrawableContainerState*) _r0.o) getConstantHeight__];
    label14:;
    [_pool release];
    return _r0.i;
    label15:;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    if (_r0.o == [NSNull null]) goto label26;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    _r0.i = [((android_graphics_drawable_Drawable*) _r0.o) getIntrinsicHeight__];
    goto label14;
    label26:;
    _r0.i = -1;
    goto label14;
}


- (int) getMinimumWidth__
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r1.o = self;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->drawableContainerState_android_graphics_drawable_DrawableContainer_DrawableContainerState retain] autorelease];
    _r0.i = [((android_graphics_drawable_DrawableContainer_DrawableContainerState*) _r0.o) isConstantSize__];
    if (_r0.i == 0) goto label15;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->drawableContainerState_android_graphics_drawable_DrawableContainer_DrawableContainerState retain] autorelease];
    _r0.i = [((android_graphics_drawable_DrawableContainer_DrawableContainerState*) _r0.o) getConstantMinimumWidth__];
    label14:;
    [_pool release];
    return _r0.i;
    label15:;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    if (_r0.o == [NSNull null]) goto label26;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    _r0.i = [((android_graphics_drawable_Drawable*) _r0.o) getMinimumWidth__];
    goto label14;
    label26:;
    _r0.i = 0;
    goto label14;
}


- (int) getMinimumHeight__
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r1.o = self;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->drawableContainerState_android_graphics_drawable_DrawableContainer_DrawableContainerState retain] autorelease];
    _r0.i = [((android_graphics_drawable_DrawableContainer_DrawableContainerState*) _r0.o) isConstantSize__];
    if (_r0.i == 0) goto label15;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->drawableContainerState_android_graphics_drawable_DrawableContainer_DrawableContainerState retain] autorelease];
    _r0.i = [((android_graphics_drawable_DrawableContainer_DrawableContainerState*) _r0.o) getConstantMinimumHeight__];
    label14:;
    [_pool release];
    return _r0.i;
    label15:;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    if (_r0.o == [NSNull null]) goto label26;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    _r0.i = [((android_graphics_drawable_Drawable*) _r0.o) getMinimumHeight__];
    goto label14;
    label26:;
    _r0.i = 0;
    goto label14;
}


- (int) isStateful__
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r1.o = self;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->drawableContainerState_android_graphics_drawable_DrawableContainer_DrawableContainerState retain] autorelease];
    _r0.i = [((android_graphics_drawable_DrawableContainer_DrawableContainerState*) _r0.o) isStateful__];
    [_pool release];
    return _r0.i;
}


- (int) selectDrawable___int :(int)n1
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    XMLVMElem _r2;
    XMLVMElem _r3;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r2.o = self;
    _r3.i = n1;
    _r1.i = ((android_graphics_drawable_DrawableContainer*) _r2.o)->currentIndex_int;
    if (_r3.i != _r1.i) goto label6;
    _r1.i = 0;
    label5:;
    [_pool release];
    return _r1.i;
    label6:;
    if (_r3.i < 0) goto label41;
    _r1.o = [[((android_graphics_drawable_DrawableContainer*) _r2.o)->drawableContainerState_android_graphics_drawable_DrawableContainer_DrawableContainerState retain] autorelease];
    _r1.i = [android_graphics_drawable_DrawableContainer_DrawableContainerState access$000___android_graphics_drawable_DrawableContainer_DrawableContainerState:_r1.o];
    if (_r3.i >= _r1.i) goto label41;
    _r1.o = [[((android_graphics_drawable_DrawableContainer*) _r2.o)->drawableContainerState_android_graphics_drawable_DrawableContainer_DrawableContainerState retain] autorelease];
    _r1.o = [[((android_graphics_drawable_DrawableContainer_DrawableContainerState*) _r1.o)->drawables_android_graphics_drawable_Drawable_ARRAYTYPE retain] autorelease];
    _r0.o = ((XMLVMArray*) _r1.o)->array.o[_r3.i];
    [[_r0.o retain] autorelease];
    _r1.o = [[((android_graphics_drawable_DrawableContainer*) _r2.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    if (_r1.o == [NSNull null]) goto label26;
    label26:;
    [_r0.o retain];
    [((android_graphics_drawable_DrawableContainer*) _r2.o)->currentDrawable_android_graphics_drawable_Drawable release];
    ((android_graphics_drawable_DrawableContainer*) _r2.o)->currentDrawable_android_graphics_drawable_Drawable = _r0.o;
    ((android_graphics_drawable_DrawableContainer*) _r2.o)->currentIndex_int = _r3.i;
    if (_r0.o == [NSNull null]) goto label39;
    _r1.o = [((android_graphics_drawable_DrawableContainer*) _r2.o) getBounds__];
    [_r1.o autorelease];
    [((android_graphics_drawable_Drawable*) _r0.o) setBounds___android_graphics_Rect:_r1.o];
    label39:;
    _r1.i = 1;
    goto label5;
    label41:;
    _r1.o = [[((android_graphics_drawable_DrawableContainer*) _r2.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    if (_r1.o == [NSNull null]) goto label45;
    label45:;
    _r1.o = [NSNull null];
    [_r1.o retain];
    [((android_graphics_drawable_DrawableContainer*) _r2.o)->currentDrawable_android_graphics_drawable_Drawable release];
    ((android_graphics_drawable_DrawableContainer*) _r2.o)->currentDrawable_android_graphics_drawable_Drawable = _r1.o;
    _r1.i = -1;
    ((android_graphics_drawable_DrawableContainer*) _r2.o)->currentIndex_int = _r1.i;
    goto label39;
}


- (android_graphics_drawable_Drawable*) getCurrent__
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r1.o = self;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    [_r0.o retain];
    [_pool release];
    return _r0.o;
}


- (int) getPadding___android_graphics_Rect :(android_graphics_Rect*)n1
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    XMLVMElem _r2;
    XMLVMElem _r3;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r2.o = self;
    _r3.o = n1;
    _r1.o = [[((android_graphics_drawable_DrawableContainer*) _r2.o)->drawableContainerState_android_graphics_drawable_DrawableContainer_DrawableContainerState retain] autorelease];
    _r0.o = [((android_graphics_drawable_DrawableContainer_DrawableContainerState*) _r1.o) getConstantPadding__];
    [_r0.o autorelease];
    if (_r0.o == [NSNull null]) goto label13;
    [((android_graphics_Rect*) _r3.o) set___android_graphics_Rect:_r0.o];
    _r1.i = 1;
    label12:;
    [_pool release];
    return _r1.i;
    label13:;
    _r1.o = [[((android_graphics_drawable_DrawableContainer*) _r2.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    if (_r1.o == [NSNull null]) goto label24;
    _r1.o = [[((android_graphics_drawable_DrawableContainer*) _r2.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    _r1.i = [((android_graphics_drawable_Drawable*) _r1.o) getPadding___android_graphics_Rect:_r3.o];
    goto label12;
    label24:;
    _r1.i = [super getPadding___android_graphics_Rect:_r3.o];
    goto label12;
}


- (void) onBoundsChange___android_graphics_Rect :(android_graphics_Rect*)n1
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    XMLVMElem _r2;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r1.o = self;
    _r2.o = n1;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    if (_r0.o == [NSNull null]) goto label9;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    [((android_graphics_drawable_Drawable*) _r0.o) setBounds___android_graphics_Rect:_r2.o];
    label9:;
    [_pool release];
    return;
}


- (void) draw___android_graphics_Canvas :(android_graphics_Canvas*)n1
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    XMLVMElem _r2;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r1.o = self;
    _r2.o = n1;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    if (_r0.o == [NSNull null]) goto label9;
    _r0.o = [[((android_graphics_drawable_DrawableContainer*) _r1.o)->currentDrawable_android_graphics_drawable_Drawable retain] autorelease];
    [((android_graphics_drawable_Drawable*) _r0.o) draw___android_graphics_Canvas:_r2.o];
    label9:;
    [_pool release];
    return;
}



@end
