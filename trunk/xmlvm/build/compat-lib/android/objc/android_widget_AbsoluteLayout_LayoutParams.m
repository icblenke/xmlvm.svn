
// Automatically generated by xmlvm2obj. Do not edit!


#import "android_widget_AbsoluteLayout_LayoutParams.h"


@implementation android_widget_AbsoluteLayout_LayoutParams;

+ (void) initialize
{
    if (strcmp(class_getName(self), "android_widget_AbsoluteLayout_LayoutParams") == 0) {
    }
}

- (id) init
{
    if (self = [super init]) {
    }
    return self;
}

- (void) dealloc
{
    [super dealloc];
}

- (void) __init_android_widget_AbsoluteLayout_LayoutParams___int_int_int_int :(int)n1 :(int)n2 :(int)n3 :(int)n4
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    XMLVMElem _r2;
    XMLVMElem _r3;
    XMLVMElem _r4;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r0.o = self;
    _r1.i = n1;
    _r2.i = n2;
    _r3.i = n3;
    _r4.i = n4;
    [((android_view_ViewGroup_LayoutParams*) _r0.o) __init_android_view_ViewGroup_LayoutParams___int_int:_r1.i:_r2.i];
    ((android_widget_AbsoluteLayout_LayoutParams*) _r0.o)->x_int = _r3.i;
    ((android_widget_AbsoluteLayout_LayoutParams*) _r0.o)->y_int = _r4.i;
    [_pool release];
    return;
}



@end
