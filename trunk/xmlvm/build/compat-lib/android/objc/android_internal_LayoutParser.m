#import "java_lang_reflect_Constructor.h"
#import "java_util_Map.h"
#import "java_lang_StringBuilder.h"
#import "android_view_View.h"
#import "org_xmlvm_iphone_NSXMLParser.h"
#import "android_view_InflateException.h"
#import "android_widget_FrameLayout_LayoutParams.h"
#import "java_util_Stack.h"
#import "android_internal_ResourceAttributes.h"
#import "java_lang_Throwable.h"
#import "java_lang_Class.h"
#import "java_lang_Object.h"
#import "android_view_ViewGroup_LayoutParams.h"
#import "java_lang_String.h"
#import "android_content_Context.h"
#import "java_lang_RuntimeException.h"
#import "android_view_ViewGroup.h"
#import "android_util_AttributeSet.h"
#import "java_lang_ClassNotFoundException.h"

// Automatically generated by xmlvm2obj. Do not edit!


#import "android_internal_LayoutParser.h"


@implementation android_internal_LayoutParser;

+ (void) initialize
{
    if (strcmp(class_getName(self), "android_internal_LayoutParser") == 0) {
    }
}

- (id) init
{
    if (self = [super init]) {
        prefix_java_lang_String = (id) [NSNull null];
        context_android_content_Context = (id) [NSNull null];
        root_android_view_ViewGroup = (id) [NSNull null];
        currentViewGroup_android_view_ViewGroup = (id) [NSNull null];
        layoutRootView_android_view_View = (id) [NSNull null];
        viewGroupStack_java_util_Stack = (id) [NSNull null];
    }
    return self;
}

- (void) dealloc
{
    [prefix_java_lang_String release];
    [context_android_content_Context release];
    [root_android_view_ViewGroup release];
    [currentViewGroup_android_view_ViewGroup release];
    [layoutRootView_android_view_View release];
    [viewGroupStack_java_util_Stack release];
    [super dealloc];
}

- (void) __init_android_internal_LayoutParser___android_content_Context_android_view_ViewGroup :(android_content_Context*)n1 :(android_view_ViewGroup*)n2
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    XMLVMElem _r2;
    XMLVMElem _r3;
    XMLVMElem _r4;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r2.o = self;
    _r3.o = n1;
    _r4.o = n2;
    _r1.o = [NSNull null];
    [((org_xmlvm_iphone_NSXMLParserDelegate*) _r2.o) __init_org_xmlvm_iphone_NSXMLParserDelegate__];
    _r0.o = @"";
    [_r0.o retain];
    [((android_internal_LayoutParser*) _r2.o)->prefix_java_lang_String release];
    ((android_internal_LayoutParser*) _r2.o)->prefix_java_lang_String = _r0.o;
    [_r1.o retain];
    [((android_internal_LayoutParser*) _r2.o)->currentViewGroup_android_view_ViewGroup release];
    ((android_internal_LayoutParser*) _r2.o)->currentViewGroup_android_view_ViewGroup = _r1.o;
    [_r1.o retain];
    [((android_internal_LayoutParser*) _r2.o)->layoutRootView_android_view_View release];
    ((android_internal_LayoutParser*) _r2.o)->layoutRootView_android_view_View = _r1.o;
    _r0.o = [[[java_util_Stack alloc] init] autorelease];
    [((java_util_Stack*) _r0.o) __init_java_util_Stack__];
    [_r0.o retain];
    [((android_internal_LayoutParser*) _r2.o)->viewGroupStack_java_util_Stack release];
    ((android_internal_LayoutParser*) _r2.o)->viewGroupStack_java_util_Stack = _r0.o;
    [_r3.o retain];
    [((android_internal_LayoutParser*) _r2.o)->context_android_content_Context release];
    ((android_internal_LayoutParser*) _r2.o)->context_android_content_Context = _r3.o;
    [_r4.o retain];
    [((android_internal_LayoutParser*) _r2.o)->root_android_view_ViewGroup release];
    ((android_internal_LayoutParser*) _r2.o)->root_android_view_ViewGroup = _r4.o;
    [_pool release];
    return;
}


- (void) didStartMappingPrefix___org_xmlvm_iphone_NSXMLParser_java_lang_String_java_lang_String :(org_xmlvm_iphone_NSXMLParser*)n1 :(java_lang_String*)n2 :(java_lang_String*)n3
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    XMLVMElem _r2;
    XMLVMElem _r3;
    XMLVMElem _r4;
    XMLVMElem _r5;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r2.o = self;
    _r3.o = n1;
    _r4.o = n2;
    _r5.o = n3;
    _r0.o = @"http://schemas.android.com/apk/res/android";
    _r0.i = [((java_lang_String*) _r5.o) equals___java_lang_Object:_r0.o];
    if (_r0.i == 0) goto label29;
    _r0.o = [[[java_lang_StringBuilder alloc] init] autorelease];
    [((java_lang_StringBuilder*) _r0.o) __init_java_lang_StringBuilder__];
    _r0.o = [((java_lang_StringBuilder*) _r0.o) append___java_lang_String:_r4.o];
    [_r0.o autorelease];
    _r1.o = @":";
    _r0.o = [((java_lang_StringBuilder*) _r0.o) append___java_lang_String:_r1.o];
    [_r0.o autorelease];
    _r0.o = [((java_lang_StringBuilder*) _r0.o) toString__];
    [_r0.o autorelease];
    [_r0.o retain];
    [((android_internal_LayoutParser*) _r2.o)->prefix_java_lang_String release];
    ((android_internal_LayoutParser*) _r2.o)->prefix_java_lang_String = _r0.o;
    label29:;
    [_pool release];
    return;
}


- (void) didStartElement___org_xmlvm_iphone_NSXMLParser_java_lang_String_java_lang_String_java_lang_String_java_util_Map :(org_xmlvm_iphone_NSXMLParser*)n1 :(java_lang_String*)n2 :(java_lang_String*)n3 :(java_lang_String*)n4 :(java_util_Map*)n5
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    XMLVMElem _r2;
    XMLVMElem _r3;
    XMLVMElem _r4;
    XMLVMElem _r5;
    XMLVMElem _r6;
    XMLVMElem _r7;
    XMLVMElem _r8;
    XMLVMElem _r9;
    XMLVMElem _r10;
    XMLVMElem _r11;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r6.o = self;
    _r7.o = n1;
    _r8.o = n2;
    _r9.o = n3;
    _r10.o = n4;
    _r11.o = n5;
    _r0.o = [[[android_internal_ResourceAttributes alloc] init] autorelease];
    _r3.o = [[((android_internal_LayoutParser*) _r6.o)->context_android_content_Context retain] autorelease];
    _r4.o = [[((android_internal_LayoutParser*) _r6.o)->prefix_java_lang_String retain] autorelease];
    [((android_internal_ResourceAttributes*) _r0.o) __init_android_internal_ResourceAttributes___android_content_Context_java_lang_String_java_util_Map:_r3.o:_r4.o:_r11.o];
    _r3.i = 46;
    _r3.i = [((java_lang_String*) _r10.o) indexOf___int:_r3.i];
    _r4.i = -1;
    if (_r3.i != _r4.i) goto label99;
    _r3.o = [[[java_lang_StringBuilder alloc] init] autorelease];
    [((java_lang_StringBuilder*) _r3.o) __init_java_lang_StringBuilder__];
    _r4.o = @"android.widget.";
    _r3.o = [((java_lang_StringBuilder*) _r3.o) append___java_lang_String:_r4.o];
    [_r3.o autorelease];
    _r3.o = [((java_lang_StringBuilder*) _r3.o) append___java_lang_String:_r10.o];
    [_r3.o autorelease];
    _r1.o = [((java_lang_StringBuilder*) _r3.o) toString__];
    [_r1.o autorelease];
    _r3.o = [[((android_internal_LayoutParser*) _r6.o)->context_android_content_Context retain] autorelease];
    _r2.o = [((android_internal_LayoutParser*) _r6.o) createView___java_lang_String_android_content_Context_android_util_AttributeSet:_r1.o:_r3.o:_r0.o];
    [_r2.o autorelease];
    if (_r2.o != [NSNull null]) goto label78;
    _r3.o = [[[java_lang_StringBuilder alloc] init] autorelease];
    [((java_lang_StringBuilder*) _r3.o) __init_java_lang_StringBuilder__];
    _r4.o = @"android.view.";
    _r3.o = [((java_lang_StringBuilder*) _r3.o) append___java_lang_String:_r4.o];
    [_r3.o autorelease];
    _r3.o = [((java_lang_StringBuilder*) _r3.o) append___java_lang_String:_r10.o];
    [_r3.o autorelease];
    _r1.o = [((java_lang_StringBuilder*) _r3.o) toString__];
    [_r1.o autorelease];
    _r3.o = [[((android_internal_LayoutParser*) _r6.o)->context_android_content_Context retain] autorelease];
    _r2.o = [((android_internal_LayoutParser*) _r6.o) createView___java_lang_String_android_content_Context_android_util_AttributeSet:_r1.o:_r3.o:_r0.o];
    [_r2.o autorelease];
    if (_r2.o != [NSNull null]) goto label78;
    _r3.o = [[((android_internal_LayoutParser*) _r6.o)->context_android_content_Context retain] autorelease];
    _r2.o = [((android_internal_LayoutParser*) _r6.o) createView___java_lang_String_android_content_Context_android_util_AttributeSet:_r10.o:_r3.o:_r0.o];
    [_r2.o autorelease];
    label78:;
    if (_r2.o == [NSNull null]) goto label106;
    [((android_internal_LayoutParser*) _r6.o) addView___android_view_View_android_util_AttributeSet:_r2.o:_r0.o];
    _r3.i = (_r2.o != [NSNull null] && 
        ([_r2.o isKindOfClass: objc_getClass("android_view_ViewGroup")] ||
         [_r2.o conformsToProtocol: objc_getProtocol("android_view_ViewGroup")])) ? 1 : 0;
    if (_r3.i == 0) goto label98;
    _r3.o = [[((android_internal_LayoutParser*) _r6.o)->viewGroupStack_java_util_Stack retain] autorelease];
    _r4.o = [[((android_internal_LayoutParser*) _r6.o)->currentViewGroup_android_view_ViewGroup retain] autorelease];
    _res = [((java_util_Stack*) _r3.o) push___java_lang_Object:_r4.o];
    [_res release];
    _r2.o = _r2.o;
    [_r2.o retain];
    [((android_internal_LayoutParser*) _r6.o)->currentViewGroup_android_view_ViewGroup release];
    ((android_internal_LayoutParser*) _r6.o)->currentViewGroup_android_view_ViewGroup = _r2.o;
    label98:;
    [_pool release];
    return;
    label99:;
    _r3.o = [[((android_internal_LayoutParser*) _r6.o)->context_android_content_Context retain] autorelease];
    _r2.o = [((android_internal_LayoutParser*) _r6.o) createView___java_lang_String_android_content_Context_android_util_AttributeSet:_r10.o:_r3.o:_r0.o];
    [_r2.o autorelease];
    goto label78;
    label106:;
    _r3.o = [[[android_view_InflateException alloc] init] autorelease];
    _r4.o = [[[java_lang_StringBuilder alloc] init] autorelease];
    [((java_lang_StringBuilder*) _r4.o) __init_java_lang_StringBuilder__];
    _r5.o = @"Unable to create widget: ";
    _r4.o = [((java_lang_StringBuilder*) _r4.o) append___java_lang_String:_r5.o];
    [_r4.o autorelease];
    _r4.o = [((java_lang_StringBuilder*) _r4.o) append___java_lang_String:_r10.o];
    [_r4.o autorelease];
    _r4.o = [((java_lang_StringBuilder*) _r4.o) toString__];
    [_r4.o autorelease];
    [((android_view_InflateException*) _r3.o) __init_android_view_InflateException___java_lang_String:_r4.o];
    @throw _r3.o;
}


- (void) didEndElement___org_xmlvm_iphone_NSXMLParser_java_lang_String_java_lang_String_java_lang_String :(org_xmlvm_iphone_NSXMLParser*)n1 :(java_lang_String*)n2 :(java_lang_String*)n3 :(java_lang_String*)n4
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    XMLVMElem _r2;
    XMLVMElem _r3;
    XMLVMElem _r4;
    XMLVMElem _r5;
    XMLVMElem _r6;
    XMLVMElem _r7;
    XMLVMElem _r8;
    XMLVMElem _r9;
    XMLVMElem _r10;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r6.o = self;
    _r7.o = n1;
    _r8.o = n2;
    _r9.o = n3;
    _r10.o = n4;
    _r5.o = @"android.widget.";
    _r0.i = 0;
    _r3.o = [[((android_internal_LayoutParser*) _r6.o)->currentViewGroup_android_view_ViewGroup retain] autorelease];
    _r3.o = [((java_lang_Object*) _r3.o) getClass__];
    [_r3.o autorelease];
    _r1.o = [((java_lang_Class*) _r3.o) getName__];
    [_r1.o autorelease];
    _r3.i = 46;
    _r3.i = [((java_lang_String*) _r10.o) indexOf___int:_r3.i];
    _r4.i = -1;
    if (_r3.i != _r4.i) goto label94;
    _r3.o = [[[java_lang_StringBuilder alloc] init] autorelease];
    [((java_lang_StringBuilder*) _r3.o) __init_java_lang_StringBuilder__];
    _r4.o = @"android.widget.";
    _r3.o = [((java_lang_StringBuilder*) _r3.o) append___java_lang_String:_r5.o];
    [_r3.o autorelease];
    _r3.o = [((java_lang_StringBuilder*) _r3.o) append___java_lang_String:_r10.o];
    [_r3.o autorelease];
    _r2.o = [((java_lang_StringBuilder*) _r3.o) toString__];
    [_r2.o autorelease];
    _r3.i = [((java_lang_String*) _r2.o) equals___java_lang_Object:_r1.o];
    if (_r3.i == 0) goto label48;
    _r0.i = 1;
    label48:;
    _r3.o = [[[java_lang_StringBuilder alloc] init] autorelease];
    [((java_lang_StringBuilder*) _r3.o) __init_java_lang_StringBuilder__];
    _r4.o = @"android.widget.";
    _r3.o = [((java_lang_StringBuilder*) _r3.o) append___java_lang_String:_r5.o];
    [_r3.o autorelease];
    _r3.o = [((java_lang_StringBuilder*) _r3.o) append___java_lang_String:_r10.o];
    [_r3.o autorelease];
    _r2.o = [((java_lang_StringBuilder*) _r3.o) toString__];
    [_r2.o autorelease];
    _r3.i = [((java_lang_String*) _r2.o) equals___java_lang_Object:_r1.o];
    if (_r3.i == 0) goto label74;
    _r0.i = 1;
    label74:;
    _r3.i = [((java_lang_String*) _r10.o) equals___java_lang_Object:_r1.o];
    if (_r3.i == 0) goto label81;
    _r0.i = 1;
    label81:;
    if (_r0.i == 0) goto label93;
    _r3.o = [[((android_internal_LayoutParser*) _r6.o)->viewGroupStack_java_util_Stack retain] autorelease];
    _r3.o = [((java_util_Stack*) _r3.o) pop__];
    [_r3.o autorelease];
    _r3.o = _r3.o;
    [_r3.o retain];
    [((android_internal_LayoutParser*) _r6.o)->currentViewGroup_android_view_ViewGroup release];
    ((android_internal_LayoutParser*) _r6.o)->currentViewGroup_android_view_ViewGroup = _r3.o;
    label93:;
    [_pool release];
    return;
    label94:;
    _r3.i = [((java_lang_String*) _r10.o) equals___java_lang_Object:_r1.o];
    if (_r3.i == 0) goto label81;
    _r0.i = 1;
    goto label81;
}


- (android_view_ViewGroup*) getCurrentView__
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r1.o = self;
    _r0.o = [[((android_internal_LayoutParser*) _r1.o)->currentViewGroup_android_view_ViewGroup retain] autorelease];
    [_r0.o retain];
    [_pool release];
    return _r0.o;
}


- (android_view_View*) getLayoutRootView__
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r1.o = self;
    _r0.o = [[((android_internal_LayoutParser*) _r1.o)->layoutRootView_android_view_View retain] autorelease];
    [_r0.o retain];
    [_pool release];
    return _r0.o;
}


- (android_view_View*) createView___java_lang_String_android_content_Context_android_util_AttributeSet :(java_lang_String*)n1 :(android_content_Context*)n2 :(android_util_AttributeSet*)n3
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    XMLVMElem _r2;
    XMLVMElem _r3;
    XMLVMElem _r4;
    XMLVMElem _r5;
    XMLVMElem _r6;
    XMLVMElem _r7;
    XMLVMElem _r8;
    XMLVMElem _r9;
    XMLVMElem _r10;
    XMLVMElem _r11;
    XMLVMElem _r12;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r9.o = self;
    _r10.o = n1;
    _r11.o = n2;
    _r12.o = n3;
    @try {
    _r1.o = [java_lang_Class forName___java_lang_String:_r10.o];
    [_r1.o autorelease];
    _r7.i = 2;
    _r4.o = [XMLVMArray createSingleDimensionWithType:0 andSize:_r7.i];
    _r7.i = 0;
    _r8.o = [[android_content_Context getClass__] autorelease];
    [_r8.o retain];
    [((XMLVMArray*) _r4.o)->array.o[_r7.i] release];
    ((XMLVMArray*) _r4.o)->array.o[_r7.i] = _r8.o;
    _r7.i = 1;
    _r8.o = [[android_util_AttributeSet getClass__] autorelease];
    [_r8.o retain];
    [((XMLVMArray*) _r4.o)->array.o[_r7.i] release];
    ((XMLVMArray*) _r4.o)->array.o[_r7.i] = _r8.o;
    _r0.o = [((java_lang_Class*) _r1.o) getConstructor___java_lang_Class_ARRAYTYPE:_r4.o];
    [_r0.o autorelease];
    _r7.i = 2;
    _r3.o = [XMLVMArray createSingleDimensionWithType:0 andSize:_r7.i];
    _r7.i = 0;
    [_r11.o retain];
    [((XMLVMArray*) _r3.o)->array.o[_r7.i] release];
    ((XMLVMArray*) _r3.o)->array.o[_r7.i] = _r11.o;
    _r7.i = 1;
    [_r12.o retain];
    [((XMLVMArray*) _r3.o)->array.o[_r7.i] release];
    ((XMLVMArray*) _r3.o)->array.o[_r7.i] = _r12.o;
    _r6.o = [((java_lang_reflect_Constructor*) _r0.o) newInstance___java_lang_Object_ARRAYTYPE:_r3.o];
    [_r6.o autorelease];
    _r6.o = _r6.o;
}
    @catch (java_lang_ClassNotFoundException* ex) {
        _ex = ex;
        goto label38;
    }
    @catch (java_lang_Throwable* ex) {
        _ex = ex;
        goto label42;
    }
    _r7 = _r6;
    label37:;
    [_r7.o retain];
    [_pool release];
    return _r7.o;
    label38:;
    _r7.o = _ex;
    _r2 = _r7;
    _r7.o = [NSNull null];
    goto label37;
    label42:;
    _r7.o = _ex;
    _r5 = _r7;
    _r7.o = [[[java_lang_RuntimeException alloc] init] autorelease];
    [((java_lang_RuntimeException*) _r7.o) __init_java_lang_RuntimeException___java_lang_Throwable:_r5.o];
    @throw _r7.o;
}


- (void) addView___android_view_View_android_util_AttributeSet :(android_view_View*)n1 :(android_util_AttributeSet*)n2
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    XMLVMElem _r1;
    XMLVMElem _r2;
    XMLVMElem _r3;
    XMLVMElem _r4;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r2.o = self;
    _r3.o = n1;
    _r4.o = n2;
    _r1.o = [[((android_internal_LayoutParser*) _r2.o)->currentViewGroup_android_view_ViewGroup retain] autorelease];
    if (_r1.o == [NSNull null]) goto label25;
    _r1.o = [[((android_internal_LayoutParser*) _r2.o)->currentViewGroup_android_view_ViewGroup retain] autorelease];
    [((android_view_ViewGroup*) _r1.o) addView___android_view_View:_r3.o];
    _r1.o = [[((android_internal_LayoutParser*) _r2.o)->currentViewGroup_android_view_ViewGroup retain] autorelease];
    _r0.o = [((android_view_ViewGroup*) _r1.o) generateLayoutParams___android_util_AttributeSet:_r4.o];
    [_r0.o autorelease];
    label15:;
    [((android_view_View*) _r3.o) setLayoutParams___android_view_ViewGroup_LayoutParams:_r0.o];
    _r1.o = [[((android_internal_LayoutParser*) _r2.o)->layoutRootView_android_view_View retain] autorelease];
    if (_r1.o != [NSNull null]) goto label24;
    [_r3.o retain];
    [((android_internal_LayoutParser*) _r2.o)->layoutRootView_android_view_View release];
    ((android_internal_LayoutParser*) _r2.o)->layoutRootView_android_view_View = _r3.o;
    label24:;
    [_pool release];
    return;
    label25:;
    _r1.o = [[((android_internal_LayoutParser*) _r2.o)->root_android_view_ViewGroup retain] autorelease];
    if (_r1.o != [NSNull null]) goto label37;
    _r0.o = [[[android_widget_FrameLayout_LayoutParams alloc] init] autorelease];
    _r1.o = [[((android_internal_LayoutParser*) _r2.o)->context_android_content_Context retain] autorelease];
    [((android_widget_FrameLayout_LayoutParams*) _r0.o) __init_android_widget_FrameLayout_LayoutParams___android_content_Context_android_util_AttributeSet:_r1.o:_r4.o];
    goto label15;
    label37:;
    _r1.o = [[((android_internal_LayoutParser*) _r2.o)->root_android_view_ViewGroup retain] autorelease];
    _r0.o = [((android_view_ViewGroup*) _r1.o) generateLayoutParams___android_util_AttributeSet:_r4.o];
    [_r0.o autorelease];
    goto label15;
}



@end
