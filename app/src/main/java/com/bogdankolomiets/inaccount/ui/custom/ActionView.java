package com.bogdankolomiets.inaccount.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.bogdankolomiets.inaccount.model.Action;

/**
 * @author bogdan
 * @version 1
 * @date 18.05.17
 */

public class ActionView extends RelativeLayout {
    private boolean mActive = false;
    private Action mAction;

    public ActionView(Context context) {
        super(context);
    }

    public ActionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ActionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setAction(Action action) {
        mAction = action;
    }

    public void activate() {

    }

    public void deactivate() {

    }
}
