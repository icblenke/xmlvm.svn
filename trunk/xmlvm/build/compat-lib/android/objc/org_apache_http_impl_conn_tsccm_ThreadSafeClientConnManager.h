#import "xmlvm.h"
#import "java_lang_Object.h"
#import "org_apache_http_conn_ClientConnectionManager.h"

// For circular include:
@class org_apache_http_impl_conn_tsccm_ThreadSafeClientConnManager;
@class android_internal_Assert;
@class java_lang_Object;
@class org_apache_http_conn_ClientConnectionManager;
@class org_apache_http_conn_scheme_SchemeRegistry;
@class org_apache_http_params_HttpParams;

// Automatically generated by xmlvm2obj. Do not edit!


	
@interface org_apache_http_impl_conn_tsccm_ThreadSafeClientConnManager : java_lang_Object <org_apache_http_conn_ClientConnectionManager>
{

}
+ (void) initialize;
- (id) init;
- (void) __init_org_apache_http_impl_conn_tsccm_ThreadSafeClientConnManager___org_apache_http_params_HttpParams_org_apache_http_conn_scheme_SchemeRegistry :(org_apache_http_params_HttpParams*)n1 :(org_apache_http_conn_scheme_SchemeRegistry*)n2;
- (void) shutdown__;

@end
