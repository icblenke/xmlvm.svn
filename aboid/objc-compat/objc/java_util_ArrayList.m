#import "java_util_ArrayList.h"


// java.util.ArrayList
//----------------------------------------------------------------------------
@implementation NSMutableArray (cat_java_util_ArrayList)

- (void) __init_java_util_ArrayList
{
}

- (void) clear
{
	[self removeAllObjects];
}


- (java_util_Iterator*) iterator
{
	return [[[java_util_Iterator alloc] init: [self objectEnumerator]] autorelease];
}

- (int) size
{
	return [self count];
}

- (BOOL) add___java_lang_Object :(java_lang_Object*) item
{
	[((NSMutableArray*) self) addObject: item];
	return TRUE;
}

- (java_lang_Object*) get___int :(int) idx
{
	return (java_lang_Object*) [self objectAtIndex: idx];
}

- (java_lang_Object*) remove___int :(int) idx
{
	java_lang_Object* o = [self objectAtIndex: idx];
	[((NSMutableArray*) self) removeObjectAtIndex: idx];
	return o;
}

- (BOOL) remove___java_lang_Object :(java_lang_Object*) item
{
	if ([((NSMutableArray*) self) indexOfObject: item] != NSNotFound) {
		[((NSMutableArray*) self) removeObject: item];
		return true;
	} else {
		return false;
	}
}

- (int) indexOf___java_lang_Object :(java_lang_Object*) item
{
	return [((NSMutableArray*) self) indexOfObject: item];
}
@end