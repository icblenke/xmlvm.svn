#import "xmlvm.h"
#import "java_lang_Object.h"
#import "android_util_Pool.h"

// For circular include:
@class java_lang_IllegalArgumentException;
@class android_util_FinitePool;
@class java_lang_Object;
@class android_util_Poolable;
@class android_util_Pool;
@class java_lang_String;
@class android_util_PoolableManager;

// Automatically generated by xmlvm2obj. Do not edit!


	
@interface android_util_FinitePool : java_lang_Object <android_util_Pool>
{
@public android_util_PoolableManager* mManager_android_util_PoolableManager;
@public int mLimit_int;
@public int mInfinite_boolean;
@public android_util_Poolable* mRoot_android_util_Poolable;
@public int mPoolCount_int;

}
+ (void) initialize;
- (id) init;
- (void) __init_android_util_FinitePool___android_util_PoolableManager :(android_util_PoolableManager*)n1;
- (void) __init_android_util_FinitePool___android_util_PoolableManager_int :(android_util_PoolableManager*)n1 :(int)n2;
- (android_util_Poolable*) acquire__;
- (void) release___android_util_Poolable :(android_util_Poolable*)n1;

@end
