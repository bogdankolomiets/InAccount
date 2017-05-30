package com.bogdankolomiets.inaccount.db.entity;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * @author bogdan
 * @version 1
 * @date 5/30/17
 */

public class ActionEntity extends RealmObject {
    @Required
    private String type;
    private int priority;

    public ActionEntity() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
