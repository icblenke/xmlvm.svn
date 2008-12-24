<?php
  include("../header.html");
  include("../content_top.html") ;
?>

<h1>How do you run an Android application on the iPhone?</h1>
	<h2>We started with an Android application...</h2>
	<table>
	<tr><td>Running in Android emulator</td><td>Java source for Android</td></tr>
	<tr>
	<td  valign =top >
	<img width = 300 src ="androidEmulator.png" /></td>
	<td>
	<textarea readonly = "true" rows = "30" cols = "60">
public class AndroidFireworks extends Activity {
	/** Called when the activity is first created. */

	public static final int UPDATE = 1337;

	Handler updater = new Handler();

	public AbsoluteLayout layout;
	public Fireworks f;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		layout = new AbsoluteLayout(this);
		setContentView(layout);
		f = new Fireworks(this);
		updater.postDelayed(updateFw, 100);
	}

	private Runnable updateFw = new Runnable() {
		public void run() {
			f.doUpdate();
			updater.postDelayed(updateFw, 50);
			layout.invalidate();

		}
	};

}
</textarea>
	</td>
	</tr>
	</table>
	
	
	
	
	<h2>
	Implemented the Android API in terms of the Java API for iPhone
	</h2>
	<table>
	<tr><td>Running in the XMLVM iPhone emulator</td><td>Example of Android compatibility library implemented in terms of the XMLVM iPhone library</td></tr>
	
	<tr>
	<td  valign =top >
	<img width = 300 src ="iphoneJavaEmulator.png" /></td>
	<td>
	<textarea readonly = "true" rows = "27" cols = "60">
package android.app;

public class Activity extends ContextThemeWrapper {
	public UIWindow window;
	public CGRect rect;
	public ActivityImpl myIphoneWrapper;

	protected void onCreate(Bundle savedInstanceState) {
		rect = UIScreen.fullScreenApplicationContentRect();

		/* Initialize the main window */
		window = new UIWindow(rect);
		window.orderFront(this.myIphoneWrapper);
		window.makeKey(this.myIphoneWrapper);
		window._setHidden(false);
	}

	public View mainView;

	public void setContentView(View view) {
		mainView = view;
		window.setContentView(view.mainView);
	}

}

    </textarea>
	</td>
	</tr>
	</table>
	
	
	
	
	<h2>
	Then cross compiled the application to objective C and compiled it with xCode and the Apple iPhone SDK
	</h2>
	<table>
	<tr><td>Running in the iPhone simulator</td><td>Example of cross compiled run method in objective C</td></tr>
	
	<tr>
	<td valign =top >
	<img width = 300 src ="iphoneEmulator.png" /></td>
	<td>
	<textarea readonly = "true" rows = "47" cols = "60">
- (void) run
{
    XMLVMElem _stack[4];
    XMLVMElem _locals[1];
    int _sp = 0;
    XMLVMElem _op1, _op2, _op3;
    int _i;
    for (_i = 0; _i <1; _i++) _locals[_i].o = nil;
    NSAutoreleasePool* _pool = [[NSAutoreleasePool alloc] init];
    _locals[0].o = self;
    label0:;
    _stack[_sp++].o = _locals[0].o;
    _op1.o = _stack[--_sp].o;
    _op2.o = ((edu_sfsu_AndroidFireworks_AndroidFireworks*) _op1.o)->f;
    _stack[_sp++].o = _op2.o;
    _sp -= 1;
    [((edu_sfsu_AndroidFireworks_Fireworks*) _stack[_sp].o) doUpdate];
    _stack[_sp++].o = _locals[0].o;
    _op1.o = _stack[--_sp].o;
    _op2.o = ((edu_sfsu_AndroidFireworks_AndroidFireworks*) _op1.o)->layout;
    _stack[_sp++].o = _op2.o;
    _sp -= 1;
    [((android_widget_AbsoluteLayout*) _stack[_sp].o) invalidate];
    _stack[_sp++].o = _locals[0].o;
    _op1.o = _stack[--_sp].o;
    _op2.o = ((edu_sfsu_AndroidFireworks_AndroidFireworks*) _op1.o)->updater;
    _stack[_sp++].o = _op2.o;
    _stack[_sp++].o = _locals[0].o;
    _stack[_sp++].l = 50;
    _sp -= 3;
    _op1.i = [((android_os_Handler*) _stack[_sp].o) postDelayed___java_lang_Runnable_long:_stack[_sp + 1].o:_stack[_sp + 2].l];
    _stack[_sp++].i = _op1.i;

_sp--;
    label1:;
    [_pool release];
    return;
}
    </textarea>
	</td>
	</tr>
	</table>
	
	<h2>How to try it</h2>
    The demo application highlighted on this page is called iFireworks.  In order to 
    try it out yourself:
    <ul>
    <li> Use Subversion to do a get on 
    <a href="http://xmlvm.svn.sourceforge.net/viewvc/xmlvm/changes/joshm/android/">
    this branch</a> </li>
    
    <li>Ensure you have <a href="http://ant.apache.org/">Ant</a> installed</li>
    <li>Ensure you have a recent <a href="http://java.sun.com/javase/downloads/index.jsp">JDK</a> installed</li>
    <li>Then navigate into XMLVM source tree you downloaded earlier and go to the <b>xmlvm</b> 
    folder. (the one that contains <b>build.xml</b></li>
    <li>execute Ant by entering the <b>ant</b> -- the project will build</li>
    <li>A directory called dist will be created, containing the following sub-directories:</li>
        <ul>
        <li>android-compat: Objective C android compatibility library </li>
        <li>androidfireworks: </li>
            <ul>
            <li> androidfireworks.jar:  Android application running in the XMLVM iPhone simulator</li>
            <li> objc: Adding everything in this directory to an xCode iPhone project will let you compile the Android fireworks project for the iPhone or iPhone simulator in xCode</li>
            </ul>
        </ul>
        
    
    </ul>
	
<?php
  include("../footer.html");
?>