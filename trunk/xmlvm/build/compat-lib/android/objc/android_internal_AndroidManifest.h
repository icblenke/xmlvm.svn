#import "xmlvm.h"
#import "java_lang_Object.h"

// For circular include:
@class android_internal_AndroidManifest_Activity;
@class java_lang_Object;
@class java_util_Map;
@class android_internal_AndroidManifest;
@class org_xmlvm_iphone_NSData;
@class java_lang_String;
@class org_xmlvm_iphone_NSBundle;
@class android_internal_AndroidManifestParser;
@class java_util_HashMap;
@class org_xmlvm_iphone_NSXMLParser;
@class org_xmlvm_iphone_NSXMLParserDelegate;

// Automatically generated by xmlvm2obj. Do not edit!


	
@interface android_internal_AndroidManifest : java_lang_Object
{
@public java_lang_String* appPackage_java_lang_String;
@public java_util_Map* activities_java_util_Map;

}
+ (void) initialize;
- (id) init;
- (void) __init_android_internal_AndroidManifest__;
- (void) addActivity___java_lang_String_android_internal_AndroidManifest_Activity :(java_lang_String*)n1 :(android_internal_AndroidManifest_Activity*)n2;
- (android_internal_AndroidManifest_Activity*) getActivity___java_lang_String :(java_lang_String*)n1;

@end
