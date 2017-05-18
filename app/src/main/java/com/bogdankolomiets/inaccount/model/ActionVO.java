package com.bogdankolomiets.inaccount.model;

/**
 * @author bogdan
 * @version 1
 * @date 18.05.17
 */

public class ActionVO {
    private String mName = "";
    private int mPriority = 0;
    private boolean mEnabled = false;

    public ActionVO(String name, int priority, boolean enabled) {
        mName = name;
        mPriority = priority;
        mEnabled = enabled;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setPriority(int priority) {
        mPriority = priority;
    }

    public boolean isEnabled() {
        return mEnabled;
    }

    public void setEnabled(boolean enabled) {
        mEnabled = enabled;
    }
}
