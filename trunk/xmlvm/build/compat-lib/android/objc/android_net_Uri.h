#import "xmlvm.h"
#import "java_lang_Object.h"

// For circular include:
@class android_internal_Assert;
@class java_lang_Object;
@class java_lang_String;
@class android_net_Uri;

// Automatically generated by xmlvm2obj. Do not edit!


	
@interface android_net_Uri : java_lang_Object
{
@public java_lang_String* uri_java_lang_String;

}
+ (void) initialize;
- (id) init;
- (void) __init_android_net_Uri___java_lang_String :(java_lang_String*)n1;
+ (android_net_Uri*) parse___java_lang_String :(java_lang_String*)n1;
- (java_lang_String*) xmlvmGetUri__;
+ (android_net_Uri*) withAppendedPath___android_net_Uri_java_lang_String :(android_net_Uri*)n1 :(java_lang_String*)n2;

@end
