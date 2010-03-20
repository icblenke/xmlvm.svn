#import "org_xmlvm_iphone_CGDataProvider.h"


// CGDataProvider
//----------------------------------------------------------------------------
@implementation org_xmlvm_iphone_CGDataProvider;

+ (org_xmlvm_iphone_CGDataProvider*) providerToPath___java_lang_String :(NSString*)n1
{
	printf("%s\n", [n1 UTF8String]);
	NSString *filePath = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:n1];

	org_xmlvm_iphone_CGDataProvider *toRet = [[org_xmlvm_iphone_CGDataProvider alloc] init];
	printf("%s\n", [filePath UTF8String]);
	toRet->provider = CGDataProviderCreateWithFilename([filePath UTF8String]);
	
	return toRet;
}
@end
