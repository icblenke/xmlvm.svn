#import "xmlvm.h"
#import "java_lang_Object.h"

// For circular include:
@class android_internal_Assert;
@class java_lang_Object;
@class java_util_List;
@class android_content_Context;
@class java_util_Locale;
@class java_lang_String;
@class android_location_Geocoder;

// Automatically generated by xmlvm2obj. Do not edit!


	
@interface android_location_Geocoder : java_lang_Object
{

}
+ (void) initialize;
- (id) init;
- (void) __init_android_location_Geocoder___android_content_Context_java_util_Locale :(android_content_Context*)n1 :(java_util_Locale*)n2;
- (java_util_List*) getFromLocation___double_double_int :(double)n1 :(double)n2 :(int)n3;
- (java_util_List*) getFromLocationName___java_lang_String_int :(java_lang_String*)n1 :(int)n2;

@end
