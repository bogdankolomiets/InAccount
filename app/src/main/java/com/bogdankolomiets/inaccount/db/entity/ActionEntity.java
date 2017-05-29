package com.bogdankolomiets.inaccount.db.entity;

import com.bogdankolomiets.inaccount.model.Action;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * @author bogdan
 * @version 1
 * @date 29.05.17
 */

public class ActionEntity extends RealmObject {
    @Required
    private int priority;
    @Required
    private Action.Type type;

    public ActionEntity(int priority, Action.Type type) {
        this.priority = priority;
        this.type = type;
    }

    public int getPriority() {
        return priority;
    }

    public Action.Type getType() {
        return type;
    }
}
