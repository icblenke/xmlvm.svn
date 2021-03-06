/*
 * Copyright (c) 2004-2009 XMLVM --- An XML-based Programming Language
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 675 Mass
 * Ave, Cambridge, MA 02139, USA.
 * 
 * For more information, visit the XMLVM Home Page at http://www.xmlvm.org
 */

#import "java_io_File.h"
#import "java_lang_StringBuffer.h"

// java.io.File
//----------------------------------------------------------------------------
@implementation java_io_File

+ (java_lang_String*) _GET_separator
{
	return [_separator retain];
}

+ (XMLVMArray*) listRoots__
{
	java_io_File* f = [[java_io_File alloc] init];
	[f __init_java_io_File___java_lang_String: @"/"];
	XMLVMArray* arr = [XMLVMArray createSingleDimensionWithType: 9 andSize: 1];
	[arr retain];
	arr->array.o[0] = f;
	return arr;
}

- (void) __init_java_io_File___java_net_URI: (java_net_URI*) uri
{
	path = [uri getPath__];
}

- (void) __init_java_io_File___java_lang_String: (java_lang_String*) pathname
{
	path = [[pathname copyWithZone: NULL] retain];
}

- (void) __init_java_io_File___java_io_File_java_lang_String: (java_io_File*) dir: (java_lang_String*) name
{
	path = [[NSMutableString alloc] init];
	[(NSMutableString*)path appendString: [dir getPath__]];
	[(NSMutableString*)path appendString: _separator];
	[(NSMutableString*)path appendString: name];
	[path retain];
}

- (bool) canRead__
{
	NSFileManager *man = [NSFileManager defaultManager];
	return [man isReadableFileAtPath: path];
}

- (bool) canWrite__ 
{
	NSFileManager *man = [NSFileManager defaultManager];
	return [man isWritableFileAtPath: path];	
}

- (bool) createNewFile__
{
	NSFileManager *man = [NSFileManager defaultManager];
	const char d[0];
	NSData *data = [NSData dataWithBytes: d length: 0];
	bool b = [man createFileAtPath: path contents: data attributes: nil];
	return b;
}

- (bool) delete__
{
	NSFileManager *man = [NSFileManager defaultManager];
	return [man removeItemAtPath: path error: NULL];
}

- (bool) exists__
{
	NSFileManager *man = [NSFileManager defaultManager];
	return [man fileExistsAtPath: path];
}

- (long) length__
{
	NSFileManager *man = [NSFileManager defaultManager];
	NSDictionary *attrs = [man attributesOfItemAtPath: path error: NULL];
	if (attrs == nil) {
		return -1;
	}
	return [attrs fileSize];
}

- (java_lang_String*) getName__
{
	return [[path lastPathComponent] retain];
}

- (java_lang_String*) getPath__
{
	return [path retain];
}

- (java_net_URI*) toURI__
{
	java_lang_StringBuffer* s = [[java_lang_StringBuffer alloc] init];
	[s append___java_lang_String: @"file://"];
	java_lang_String* s2 = [self getAbsolutePath__];
	[s append___java_lang_String: s2];
	[s2 release];
	java_net_URI* u = [[java_net_URI alloc] initWithString: s];
	[s release];
	return u;
}

- (bool) isDirectory__
{	
	BOOL isDir = true;
	NSFileManager *man = [NSFileManager defaultManager];
	[man fileExistsAtPath: path isDirectory: &isDir];
	return isDir;
}

- (bool) isHidden__
{
	NSFileManager *man = [NSFileManager defaultManager];
	NSDictionary *attrs = [man attributesOfItemAtPath: path error: NULL];
	if (attrs == nil) {
		return -1;
	}
	NSNumber *n = [attrs objectForKey: NSFileExtensionHidden];
	return [n boolValue];
}

- (long) lastModified__
{
/*	NSFileManager *man = [NSFileManager defaultManager];
	NSDictionary *attrs = [man attributesOfItemAtPath: path error: NULL];
	NSDate *n = [attrs fileModificationDate];*/
	NSDate *n = [NSDate date];//TODO real
	return (long) ([n timeIntervalSince1970] * 1000);
}

- (XMLVMArray*) list__
{
	NSFileManager *man = [NSFileManager defaultManager];
	NSArray *files = [man contentsOfDirectoryAtPath: path error: NULL];
	if (files == nil) {
		return [NSNull null];
	}
	int count = [files count];
	XMLVMArray* f = [XMLVMArray createSingleDimensionWithType: 9 andSize: count];
	[f retain];
	for (int i = 0; i < count; ++i) {
		java_lang_String* s = [files objectAtIndex: i];
		[s retain];
		f->array.o[i] = s;
	}
	return f;
}

- (XMLVMArray*) list___java_io_FilenameFilter: (java_io_FilenameFilter*) filter
{
	NSFileManager *man = [NSFileManager defaultManager];
	
	NSArray *files = [man contentsOfDirectoryAtPath: path error: NULL];
	if (files == nil) {
		return [NSNull null];
	}
	
	NSMutableArray *arr = [NSMutableArray arrayWithCapacity: [files count]];
	for (java_lang_String *s in files) {
		if ([filter accept___java_io_File_java_lang_String: self : s]) {
			[arr addObject: s];
		}
	}
	
	int count = [arr count];
	
	XMLVMArray* f = [XMLVMArray createSingleDimensionWithType: 9 andSize: count];
	[f retain];
	for (int i = 0; i < count; ++i) {
		java_lang_String* s = [arr objectAtIndex: i];
		[s retain];
		f->array.o[i] = s;
	}
	
	return f;	
}

- (XMLVMArray*) listFiles__
{
	NSFileManager *man = [NSFileManager defaultManager];
	NSArray *files = [man contentsOfDirectoryAtPath: path error: NULL];
	if (files == nil) {
		return [NSNull null];
	}
	int count = [files count];
	XMLVMArray* f = [XMLVMArray createSingleDimensionWithType: 9 andSize: count];
	[f retain];
	for (int i = 0; i < count; ++i) {
		java_lang_String* s = [files objectAtIndex: i];
		java_io_File* fi = [[java_io_File alloc] init];
		[fi __init_java_io_File___java_io_File_java_lang_String: self : path];
		f->array.o[i] = [fi retain];
	}
	return f;
}

- (XMLVMArray*) listFiles___java_io_FilenameFilter: (java_io_FilenameFilter*) filter
{
	NSFileManager *man = [NSFileManager defaultManager];
	
	NSArray *files = [man contentsOfDirectoryAtPath: path error: NULL];
	if (files == nil) {
		return nil;
	}
	
	NSMutableArray *arr = [NSMutableArray arrayWithCapacity: [files count]];
	for (java_lang_String *s in files) {
		if ([filter accept___java_io_File_java_lang_String: self : s]) {
			[arr addObject: s];
		}
	}
	
	int count = [arr count];
	
	XMLVMArray* f = [XMLVMArray createSingleDimensionWithType: 9 andSize: count];
	[f retain];
	for (int i = 0; i < count; ++i) {
		java_lang_String* s = [arr objectAtIndex: i];
		java_io_File* fi = [[java_io_File alloc] init];
		[fi __init_java_io_File___java_io_File_java_lang_String: self : s];
		f->array.o[i] = [fi retain];
	}
	
	return f;		
}

- (bool) mkdir__
{
	NSFileManager *man = [NSFileManager defaultManager];
	return [man createDirectoryAtPath: path withIntermediateDirectories: false attributes: nil error: NULL];
}

- (bool) mkdirs__
{
	NSFileManager *man = [NSFileManager defaultManager];
	return [man createDirectoryAtPath: path withIntermediateDirectories: true attributes: nil error: NULL];
}

- (java_lang_String*) getAbsolutePath__
{
	if ([path startsWith___java_lang_String: _separator]) {
		return path;
	}
	NSFileManager *man = [NSFileManager defaultManager];
	NSString *currentDir = [man currentDirectoryPath];
	if (currentDir == nil) {
		return path;
	}
	NSMutableString* s = [NSMutableString stringWithString: currentDir];
	if (! [s endsWith___java_lang_String:_separator]) {
		[s appendString: _separator];
	}
	[s appendString: path];	
	NSString *s2 = [s stringByStandardizingPath];
	return [s2 retain];
	
}

- (java_lang_String*) getCanonicalPath__
{
	return [self getAbsolutePath__];
}


- (long) getUsableSpace__
{
	int64_t totalSpace = 0;  
    NSError *error = nil;  
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);  
    NSDictionary *dictionary = [[NSFileManager defaultManager] attributesOfFileSystemForPath:[paths lastObject] error: &error];  
    if (dictionary) {  
        NSNumber *fileSystemSizeInBytes = [dictionary objectForKey: NSFileSystemFreeSize];  
        totalSpace = [fileSystemSizeInBytes longLongValue];  
    }
    return totalSpace / 1024;  //TODO real, it's KByte.
}

- (bool) renameTo___java_io_File: (java_io_File*) f
{
	NSFileManager *man = [NSFileManager defaultManager];
	return [man moveItemAtPath: path toPath: [f getCanonicalPath__] error: NULL];
}

@end

