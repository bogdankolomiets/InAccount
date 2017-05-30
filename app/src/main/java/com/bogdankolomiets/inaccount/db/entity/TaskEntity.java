package com.bogdankolomiets.inaccount.db.entity;

import com.bogdankolomiets.inaccount.model.Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * @author bogdan
 * @version 1
 * @date 29.05.17
 */

public class TaskEntity extends RealmObject {
    @PrimaryKey
    private String UUID;
    private boolean hasProfilePhoto;
    private int subscribersCount;
    private int subscriptionCount;
    @Required
    private Action[] mActions;
    @Required
    private String searchType;

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public void setHasProfilePhoto(boolean hasProfilePhoto) {
        this.hasProfilePhoto = hasProfilePhoto;
    }

    public void setSubscribersCount(int subscribersCount) {
        this.subscribersCount = subscribersCount;
    }

    public void setSubscriptionCount(int subscriptionCount) {
        this.subscriptionCount = subscriptionCount;
    }

    public void setActions(List<Action> actions) {
        mActions = new Action[actions.size()];
        for (int i = 0; i < actions.size(); i++) {
            mActions[i] = actions.get(i);
        }
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getUUID() {
        return UUID;
    }

    public boolean isHasProfilePhoto() {
        return hasProfilePhoto;
    }

    public int getSubscribersCount() {
        return subscribersCount;
    }

    public int getSubscriptionCount() {
        return subscriptionCount;
    }

    public List<Action> getActions() {
        return Arrays.asList(mActions);
    }

    public String getSearchType() {
        return searchType;
    }
}
