package com.bogdankolomiets.inaccount;

import com.google.gson.internal.Primitives;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 06.03.17
 */

public class PresenterFactory {
    private static PresenterFactory sInstance;

    private PresenterFactory() {

    }

    public static PresenterFactory getInstance() {
        if (sInstance == null) {
            synchronized (PresenterFactory.class) {
                sInstance = new PresenterFactory();
            }
        }

        return sInstance;
    }

    public <T> T get(Class<T> type) {
        Object object = null;

        if (object == null) {
            throw new ClassCastException("Unknown class");
        }
        return Primitives.wrap(type).cast(object);
    }
}
