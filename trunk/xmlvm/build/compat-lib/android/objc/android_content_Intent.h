#import "xmlvm.h"
#import "java_lang_Object.h"

// For circular include:
@class java_lang_Object;
@class java_lang_String;
@class android_os_Bundle;
@class java_lang_CharSequence;
@class android_internal_Assert;
@class android_content_Intent;
@class android_content_Context;
@class java_lang_Class;
@class java_io_Serializable;
@class android_net_Uri;

// Automatically generated by xmlvm2obj. Do not edit!


	
@interface android_content_Intent : java_lang_Object
{
@public java_lang_String* action_java_lang_String;
@public android_net_Uri* uri_android_net_Uri;
@public android_os_Bundle* extras_android_os_Bundle;

}
+ (void) initialize;
- (id) init;
+ (java_lang_String*) _GET_ACTION_VIEW;
+ (void) _PUT_ACTION_VIEW: (java_lang_String*) v;
+ (java_lang_String*) _GET_ACTION_SEND;
+ (void) _PUT_ACTION_SEND: (java_lang_String*) v;
+ (java_lang_String*) _GET_ACTION_DIAL;
+ (void) _PUT_ACTION_DIAL: (java_lang_String*) v;
+ (java_lang_String*) _GET_EXTRA_SUBJECT;
+ (void) _PUT_EXTRA_SUBJECT: (java_lang_String*) v;
+ (java_lang_String*) _GET_EXTRA_TEXT;
+ (void) _PUT_EXTRA_TEXT: (java_lang_String*) v;
- (void) __init_android_content_Intent__;
- (void) __init_android_content_Intent___java_lang_String :(java_lang_String*)n1;
- (void) __init_android_content_Intent___android_content_Context_java_lang_Class :(android_content_Context*)n1 :(java_lang_Class*)n2;
- (java_lang_String*) getAction__;
- (android_net_Uri*) xmlvmGetUri__;
- (void) __init_android_content_Intent___java_lang_String_android_net_Uri :(java_lang_String*)n1 :(android_net_Uri*)n2;
- (void) setData___android_net_Uri :(android_net_Uri*)n1;
- (android_os_Bundle*) getExtras__;
- (android_content_Intent*) putExtra___java_lang_String_int :(java_lang_String*)n1 :(int)n2;
- (android_net_Uri*) getData__;
- (java_lang_String*) getDataString__;
- (double) getDoubleExtra___java_lang_String_double :(java_lang_String*)n1 :(double)n2;
- (java_lang_String*) getStringExtra___java_lang_String :(java_lang_String*)n1;
+ (android_content_Intent*) createChooser___android_content_Intent_java_lang_CharSequence :(android_content_Intent*)n1 :(java_lang_CharSequence*)n2;
- (android_content_Intent*) putExtra___java_lang_String_java_lang_String :(java_lang_String*)n1 :(java_lang_String*)n2;
- (void) setType___java_lang_String :(java_lang_String*)n1;
- (android_content_Intent*) setAction___java_lang_String :(java_lang_String*)n1;
- (android_content_Intent*) setDataAndType___android_net_Uri_java_lang_String :(android_net_Uri*)n1 :(java_lang_String*)n2;
- (int) getBooleanExtra___java_lang_String_boolean :(java_lang_String*)n1 :(int)n2;
- (android_content_Intent*) putExtra___java_lang_String_java_io_Serializable :(java_lang_String*)n1 :(java_io_Serializable*)n2;

@end
