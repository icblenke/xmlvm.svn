package android.app;

import org.xmlvm.iphone.NSNotification;
import org.xmlvm.iphone.UIApplication;

import edu.sfsu.AndroidFireworks.AndroidFireworks;


public class ActivityImpl extends UIApplication
{	
	public static ActivityImpl rootApp; 
	Activity parent; 
	
	public ActivityImpl __xmlvm_iphone_entrypoint(ActivityImpl me)
	{
	
		// Iphone entry point. -- we get constructed, and then iphone calls back into us.
    	AndroidFireworks fw = new AndroidFireworks();
    	me.parent = fw;
		fw.myIphoneWrapper = me;
		return me;
	}
	public static void main(String [] args, Activity toRun)
	{
		// launch point for java land
		ActivityImpl implementaton = new ActivityImpl(toRun);
		toRun.myIphoneWrapper = implementaton;
		implementaton.applicationDidFinishLaunching(null);
	}
	public ActivityImpl(Activity parent)
	{
		this.parent = parent;
	}
    public void applicationDidFinishLaunching(NSNotification aNotification)
    {
	   parent.onCreate(null);  
    }

    
    public ActivityImpl()
    {
    	rootApp = __xmlvm_iphone_entrypoint(this);
    }

}