#import "xmlvm.h"
#import "java_lang_Object.h"

// For circular include:
@class java_lang_Object;
@class java_lang_String;

// Automatically generated by xmlvm2obj. Do not edit!


	
@protocol android_provider_Contacts_PhonesColumns
+ (void) initialize;
- (id) init;
+ (java_lang_String*) _GET_TYPE;
+ (void) _PUT_TYPE: (java_lang_String*) v;
+ (int) _GET_TYPE_CUSTOM;
+ (void) _PUT_TYPE_CUSTOM: (int) v;
+ (int) _GET_TYPE_HOME;
+ (void) _PUT_TYPE_HOME: (int) v;
+ (int) _GET_TYPE_MOBILE;
+ (void) _PUT_TYPE_MOBILE: (int) v;
+ (int) _GET_TYPE_WORK;
+ (void) _PUT_TYPE_WORK: (int) v;
+ (int) _GET_TYPE_FAX_WORK;
+ (void) _PUT_TYPE_FAX_WORK: (int) v;
+ (int) _GET_TYPE_FAX_HOME;
+ (void) _PUT_TYPE_FAX_HOME: (int) v;
+ (int) _GET_TYPE_PAGER;
+ (void) _PUT_TYPE_PAGER: (int) v;
+ (int) _GET_TYPE_OTHER;
+ (void) _PUT_TYPE_OTHER: (int) v;
+ (java_lang_String*) _GET_LABEL;
+ (void) _PUT_LABEL: (java_lang_String*) v;
+ (java_lang_String*) _GET_NUMBER;
+ (void) _PUT_NUMBER: (java_lang_String*) v;
+ (java_lang_String*) _GET_NUMBER_KEY;
+ (void) _PUT_NUMBER_KEY: (java_lang_String*) v;
+ (java_lang_String*) _GET_ISPRIMARY;
+ (void) _PUT_ISPRIMARY: (java_lang_String*) v;

@end

@interface android_provider_Contacts_PhonesColumns : java_lang_Object <android_provider_Contacts_PhonesColumns>
@end