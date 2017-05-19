package com.bogdankolomiets.inaccount.model;

import java.util.List;

/**
 * @author bogdan
 * @version 1
 * @date 18.05.17
 */

public class Task {
    private boolean mHasProfilePhoto;
    private int mSubscribersCount;
    private int mSubscroptionsCount;
    private List<Action> mActions;

    public Task() {

    }

    public void setActions(List<Action> actions) {
        mActions = actions;
    }

    public void setHasProfilePhoto(boolean hasProfilePhoto) {
        mHasProfilePhoto = hasProfilePhoto;
    }

    public void setSubscribersCount(int subscribersCount) {
        mSubscribersCount = subscribersCount;
    }

    public void setSubscroptionsCount(int subscroptionsCount) {
        mSubscroptionsCount = subscroptionsCount;
    }


}
