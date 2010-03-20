#import "xmlvm.h"
#import "java_lang_Object.h"

// For circular include:
@class android_hardware_Sensor;
@class java_lang_Object;
@class java_lang_String;

// Automatically generated by xmlvm2obj. Do not edit!


	
@interface android_hardware_Sensor : java_lang_Object
{
@public java_lang_String* mName_java_lang_String;
@public java_lang_String* mVendor_java_lang_String;
@public int mVersion_int;
@public int mHandle_int;
@public int mType_int;
@public float mMaxRange_float;
@public float mResolution_float;
@public float mPower_float;
@public int mLegacyType_int;

}
+ (void) initialize;
- (id) init;
+ (int) _GET_TYPE_ACCELEROMETER;
+ (void) _PUT_TYPE_ACCELEROMETER: (int) v;
+ (int) _GET_TYPE_MAGNETIC_FIELD;
+ (void) _PUT_TYPE_MAGNETIC_FIELD: (int) v;
+ (int) _GET_TYPE_ORIENTATION;
+ (void) _PUT_TYPE_ORIENTATION: (int) v;
+ (int) _GET_TYPE_GYROSCOPE;
+ (void) _PUT_TYPE_GYROSCOPE: (int) v;
+ (int) _GET_TYPE_LIGHT;
+ (void) _PUT_TYPE_LIGHT: (int) v;
+ (int) _GET_TYPE_PRESSURE;
+ (void) _PUT_TYPE_PRESSURE: (int) v;
+ (int) _GET_TYPE_TEMPERATURE;
+ (void) _PUT_TYPE_TEMPERATURE: (int) v;
+ (int) _GET_TYPE_PROXIMITY;
+ (void) _PUT_TYPE_PROXIMITY: (int) v;
+ (int) _GET_TYPE_ALL;
+ (void) _PUT_TYPE_ALL: (int) v;
- (void) __init_android_hardware_Sensor__;
- (void) __init_android_hardware_Sensor___int :(int)n1;
- (java_lang_String*) getName__;
- (java_lang_String*) getVendor__;
- (int) getType__;
- (int) getVersion__;
- (float) getMaximumRange__;
- (float) getResolution__;
- (float) getPower__;
- (int) getHandle__;
- (void) setRange___float_float :(float)n1 :(float)n2;
- (void) setLegacyType___int :(int)n1;
- (int) getLegacyType__;

@end
