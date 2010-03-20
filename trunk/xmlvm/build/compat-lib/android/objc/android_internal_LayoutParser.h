#import "xmlvm.h"
#import "org_xmlvm_iphone_NSXMLParserDelegate.h"

// For circular include:
@class java_lang_reflect_Constructor;
@class java_util_Map;
@class android_internal_LayoutParser;
@class java_lang_StringBuilder;
@class android_view_View;
@class org_xmlvm_iphone_NSXMLParser;
@class android_view_InflateException;
@class android_widget_FrameLayout_LayoutParams;
@class java_util_Stack;
@class android_internal_ResourceAttributes;
@class java_lang_Throwable;
@class java_lang_Class;
@class java_lang_Object;
@class android_view_ViewGroup_LayoutParams;
@class java_lang_String;
@class android_content_Context;
@class org_xmlvm_iphone_NSXMLParserDelegate;
@class java_lang_RuntimeException;
@class android_view_ViewGroup;
@class android_util_AttributeSet;
@class java_lang_ClassNotFoundException;

// Automatically generated by xmlvm2obj. Do not edit!


	
@interface android_internal_LayoutParser : org_xmlvm_iphone_NSXMLParserDelegate
{
@public java_lang_String* prefix_java_lang_String;
@public android_content_Context* context_android_content_Context;
@public android_view_ViewGroup* root_android_view_ViewGroup;
@public android_view_ViewGroup* currentViewGroup_android_view_ViewGroup;
@public android_view_View* layoutRootView_android_view_View;
@public java_util_Stack* viewGroupStack_java_util_Stack;

}
+ (void) initialize;
- (id) init;
- (void) __init_android_internal_LayoutParser___android_content_Context_android_view_ViewGroup :(android_content_Context*)n1 :(android_view_ViewGroup*)n2;
- (void) didStartMappingPrefix___org_xmlvm_iphone_NSXMLParser_java_lang_String_java_lang_String :(org_xmlvm_iphone_NSXMLParser*)n1 :(java_lang_String*)n2 :(java_lang_String*)n3;
- (void) didStartElement___org_xmlvm_iphone_NSXMLParser_java_lang_String_java_lang_String_java_lang_String_java_util_Map :(org_xmlvm_iphone_NSXMLParser*)n1 :(java_lang_String*)n2 :(java_lang_String*)n3 :(java_lang_String*)n4 :(java_util_Map*)n5;
- (void) didEndElement___org_xmlvm_iphone_NSXMLParser_java_lang_String_java_lang_String_java_lang_String :(org_xmlvm_iphone_NSXMLParser*)n1 :(java_lang_String*)n2 :(java_lang_String*)n3 :(java_lang_String*)n4;
- (android_view_ViewGroup*) getCurrentView__;
- (android_view_View*) getLayoutRootView__;
- (android_view_View*) createView___java_lang_String_android_content_Context_android_util_AttributeSet :(java_lang_String*)n1 :(android_content_Context*)n2 :(android_util_AttributeSet*)n3;
- (void) addView___android_view_View_android_util_AttributeSet :(android_view_View*)n1 :(android_util_AttributeSet*)n2;

@end
