package com.bogdankolomiets.inaccount.model;

import android.support.annotation.NonNull;

/**
 * @author bogdan
 * @version 1
 * @date 18.05.17
 */

public class Action implements Comparable<Action> {
    private final Type mType;
    private int mPriority;

    public Action(Type type) {
        this(type, 0);
    }

    public Action(Type type, int priority) {
        mType = type;
        mPriority = priority;
    }

    public void setPriority(int priority) {
        mPriority = priority;
    }

    public Type getType() {
        return mType;
    }

    public int getPriority() {
        return mPriority;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Action)) return false;

        Action action = (Action) o;

        if (mPriority != action.mPriority) return false;
        return mType == action.mType;

    }

    @Override
    public int hashCode() {
        int result = mType.hashCode();
        result = 31 * result + mPriority;
        return result;
    }

    @Override
    public String toString() {
        return "Action{" +
                "mType=" + mType +
                ", mPriority=" + mPriority +
                '}';
    }

    @Override
    public int compareTo(@NonNull Action o) {
        return mPriority - o.getPriority();
    }

    public enum Type {
        LIKE,
        SUBSCRIBE,
        COMMENT,
        UNSUBSCRIBE;
    }
}
