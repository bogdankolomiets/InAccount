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
    private String mSearchType;

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

    public void setSearchType(String searchType) {
        mSearchType = searchType;
    }

    public boolean isHasProfilePhoto() {
        return mHasProfilePhoto;
    }

    public int getSubscribersCount() {
        return mSubscribersCount;
    }

    public int getSubscroptionsCount() {
        return mSubscroptionsCount;
    }

    public List<Action> getActions() {
        return mActions;
    }

    public String getSearchType() {
        return mSearchType;
    }
}
