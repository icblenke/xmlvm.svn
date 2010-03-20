#import "org_xmlvm_iphone_NSData.h"
#import "android_internal_LayoutParser.h"
#import "java_lang_String.h"
#import "java_lang_StringBuilder.h"
#import "android_view_View.h"
#import "org_xmlvm_iphone_NSXMLParser.h"
#import "android_view_InflateException.h"
#import "android_content_Context.h"
#import "org_xmlvm_iphone_NSXMLParserDelegate.h"
#import "android_view_ViewGroup.h"
#import "android_content_res_Resources.h"

// Automatically generated by xmlvm2obj. Do not edit!


#import "android_internal_LayoutManager.h"


@implementation android_internal_LayoutManager;

+ (void) initialize
{
    if (strcmp(class_getName(self), "android_internal_LayoutManager") == 0) {
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

- (void) __init_android_internal_LayoutManager__
{
    id        _res;
    id        _ex;
    XMLVMElem _r0;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r0.o = self;
    [((java_lang_Object*) _r0.o) __init_java_lang_Object__];
    [_pool release];
    return;
}


+ (android_view_View*) getLayout___android_content_Context_int_android_view_ViewGroup :(android_content_Context*)n1 :(int)n2 :(android_view_ViewGroup*)n3
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
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _r7.o = n1;
    _r8.i = n2;
    _r9.o = n3;
    _r5.i = 1;
    _r4.o = [((android_content_Context*) _r7.o) getResources__];
    [_r4.o autorelease];
    _r0.o = [((android_content_res_Resources*) _r4.o) getLayout___int:_r8.i];
    [_r0.o autorelease];
    _r3.o = [[[org_xmlvm_iphone_NSXMLParser alloc] init] autorelease];
    [((org_xmlvm_iphone_NSXMLParser*) _r3.o) __init_org_xmlvm_iphone_NSXMLParser___org_xmlvm_iphone_NSData:_r0.o];
    [((org_xmlvm_iphone_NSXMLParser*) _r3.o) setShouldProcessNamespaces___boolean:_r5.i];
    [((org_xmlvm_iphone_NSXMLParser*) _r3.o) setShouldReportNamespacePrefixes___boolean:_r5.i];
    _r1.o = [[[android_internal_LayoutParser alloc] init] autorelease];
    [((android_internal_LayoutParser*) _r1.o) __init_android_internal_LayoutParser___android_content_Context_android_view_ViewGroup:_r7.o:_r9.o];
    [((org_xmlvm_iphone_NSXMLParser*) _r3.o) setDelegate___org_xmlvm_iphone_NSXMLParserDelegate:_r1.o];
    _r2.i = [((org_xmlvm_iphone_NSXMLParser*) _r3.o) parse__];
    if (_r2.i != 0) goto label59;
    _r4.o = [[[android_view_InflateException alloc] init] autorelease];
    _r5.o = [[[java_lang_StringBuilder alloc] init] autorelease];
    [((java_lang_StringBuilder*) _r5.o) __init_java_lang_StringBuilder__];
    _r6.o = @"Unable to inflate layout: ";
    _r5.o = [((java_lang_StringBuilder*) _r5.o) append___java_lang_String:_r6.o];
    [_r5.o autorelease];
    _r5.o = [((java_lang_StringBuilder*) _r5.o) append___int:_r8.i];
    [_r5.o autorelease];
    _r5.o = [((java_lang_StringBuilder*) _r5.o) toString__];
    [_r5.o autorelease];
    [((android_view_InflateException*) _r4.o) __init_android_view_InflateException___java_lang_String:_r5.o];
    @throw _r4.o;
    label59:;
    _r4.o = [((android_internal_LayoutParser*) _r1.o) getLayoutRootView__];
    [_r4.o autorelease];
    [_r4.o retain];
    [_pool release];
    return _r4.o;
}



@end
