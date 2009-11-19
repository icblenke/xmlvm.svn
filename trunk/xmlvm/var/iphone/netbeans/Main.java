/*
 * XMLVM demo template of Hello World application
 */
package xmlvm;

import org.xmlvm.iphone.CGRect;
import org.xmlvm.iphone.UIApplication;
import org.xmlvm.iphone.UILabel;
import org.xmlvm.iphone.UIScreen;
import org.xmlvm.iphone.UITextAlignment;
import org.xmlvm.iphone.UIView;
import org.xmlvm.iphone.UIWindow;

public class Main extends UIApplication {

    public void applicationDidFinishLaunching(UIApplication app) {
        UIScreen mainscreen = UIScreen.mainScreen();
        CGRect rect = mainscreen.getApplicationFrame();
        UIWindow window = new UIWindow(rect);

        rect.origin.x = rect.origin.y = 0;
        UIView mainView = new UIView(rect);
        window.addSubview(mainView);

        UILabel title = new UILabel(rect);
        title.setText("Hello World!");
        title.setTextAlignment(UITextAlignment.Center);
        mainView.addSubview(title);

        window.makeKeyAndVisible();
    }

    public static void main(String[] args) {
        UIApplication.main(args, Main.class);
    }
}