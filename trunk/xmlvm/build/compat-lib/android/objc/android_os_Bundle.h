#import "xmlvm.h"
#import "java_lang_Object.h"

// For circular include:
@class android_internal_Assert;
@class java_lang_Object;
@class java_lang_Integer;
@class java_lang_String;
@class java_util_HashMap;
@class android_os_Bundle;

// Automatically generated by xmlvm2obj. Do not edit!


	
@interface android_os_Bundle : java_lang_Object
{
@public java_util_HashMap* map_java_util_HashMap;

}
+ (void) initialize;
- (id) init;
- (void) __init_android_os_Bundle__;
- (int) getInt___java_lang_String :(java_lang_String*)n1;
- (void) putInt___java_lang_String_int :(java_lang_String*)n1 :(int)n2;
- (int) getBoolean___java_lang_String :(java_lang_String*)n1;
- (void) putBoolean___java_lang_String_boolean :(java_lang_String*)n1 :(int)n2;
- (double) getDouble___java_lang_String :(java_lang_String*)n1;
- (void) putDouble___java_lang_String_double :(java_lang_String*)n1 :(double)n2;
- (java_lang_String*) getString___java_lang_String :(java_lang_String*)n1;
- (void) putString___java_lang_String_java_lang_String :(java_lang_String*)n1 :(java_lang_String*)n2;

@end
