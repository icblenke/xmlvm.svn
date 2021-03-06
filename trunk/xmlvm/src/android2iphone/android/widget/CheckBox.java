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

package android.widget;

import org.xmlvm.iphone.CGRect;
import org.xmlvm.iphone.UISwitch;
import org.xmlvm.iphone.UIView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

public class CheckBox extends CompoundButton {

    public CheckBox(Context c) {
        super(c);
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams l) {
        layoutParams = l;

        if (l instanceof AbsoluteLayout.LayoutParams) {
            AbsoluteLayout.LayoutParams a = (AbsoluteLayout.LayoutParams) l;
            getUISwitch()
                    .setFrame(
                            new CGRect(a.x, a.y, UISwitch.kSwitchButtonWidth,
                                    UISwitch.kSwitchButtonHeight));
        }
    }

    @Override
    public boolean isChecked() {
        return getUISwitch().isOn();
    }

    @Override
    public void setChecked(boolean checked) {
        getUISwitch().setOn(checked);
    }

    public void setSelected(boolean b) {
        // TODO Auto-generated method stub

    }

    @Override
    protected UIView xmlvmCreateUIView(AttributeSet attrs) {
        // TODO mapping a CheckBox to a UISwitch is not entirely correct since
        // the latter does not setText()
        return new UISwitch();
    }

    private UISwitch getUISwitch() {
        return (UISwitch) xmlvmGetUIView();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension((int) UISwitch.kSwitchButtonWidth + paddingLeft + paddingRight,
                (int) UISwitch.kSwitchButtonHeight + paddingTop + paddingBottom);
    }

    @Override
    protected void xmlvmUpdateUIView(boolean checked) {
        // TODO Auto-generated method stub
        Log.w("xmlvm", "CheckBox.xmlvmUpdateUIView() not implemented");
    }

}
