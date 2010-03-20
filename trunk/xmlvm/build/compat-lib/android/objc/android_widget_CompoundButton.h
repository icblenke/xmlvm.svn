#import "xmlvm.h"
#import "android_widget_Button.h"

// For circular include:
@class android_widget_Button;
@class android_internal_Assert;
@class android_widget_CompoundButton;
@class android_content_Context;
@class org_xmlvm_iphone_UIEvent;
@class android_util_AttributeSet;
@class java_util_Set;
@class android_widget_CompoundButton_OnCheckedChangeListener;

// Automatically generated by xmlvm2obj. Do not edit!


	
@interface android_widget_CompoundButton : android_widget_Button
{
@public int checked_boolean;

}
+ (void) initialize;
- (id) init;
+ (XMLVMArray*) _GET_CHECKED_STATE_SET;
+ (void) _PUT_CHECKED_STATE_SET: (XMLVMArray*) v;
- (void) __init_android_widget_CompoundButton___android_content_Context :(android_content_Context*)n1;
- (void) __init_android_widget_CompoundButton___android_content_Context_android_util_AttributeSet :(android_content_Context*)n1 :(android_util_AttributeSet*)n2;
- (void) initCompoundButton___android_content_Context_android_util_AttributeSet :(android_content_Context*)n1 :(android_util_AttributeSet*)n2;
- (void) parseCompoundButtonAttributes___android_util_AttributeSet :(android_util_AttributeSet*)n1;
- (void) setOnCheckedChangeListener___android_widget_CompoundButton_OnCheckedChangeListener :(android_widget_CompoundButton_OnCheckedChangeListener*)n1;
- (void) setChecked___boolean :(int)n1;
- (int) isChecked__;
- (void) toggle__;
- (void) xmlvmUpdateUIView___boolean :(int)n1;
- (int) processTouchesEvent___int_java_util_Set_org_xmlvm_iphone_UIEvent :(int)n1 :(java_util_Set*)n2 :(org_xmlvm_iphone_UIEvent*)n3;
+ (void) __clinit_android_widget_CompoundButton;

@end
