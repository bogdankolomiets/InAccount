package com.bogdankolomiets.inaccount.model;

import java.util.List;

/**
 * @author bogdan
 * @version 1
 * @date 18.05.17
 */

public class Task {
    private boolean mHasProfilePhoto;
    private String mSubscribersCount;
    private String mSubscroptionsCount;
    private List<Action> mActions;

    public Task() {

    }

    public void setActions(List<Action> actions) {
        mActions = actions;
    }
}
