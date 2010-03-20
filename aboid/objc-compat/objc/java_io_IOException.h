
#import "xmlvm.h"
#import "java_lang_Exception.h"


// java.io.IOException
//----------------------------------------------------------------------------
// For some reason, compiling for the device doesn't like to define this
// class as a category.
@interface java_io_IOException : java_lang_Exception

- (id) init;
- (void) __init_java_io_IOException;

@end
