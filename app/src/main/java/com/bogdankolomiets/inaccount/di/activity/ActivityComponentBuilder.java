package com.bogdankolomiets.inaccount.di.activity;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */

public interface ActivityComponentBuilder<M extends ActivityModule, C extends ActivityComponent> {
    ActivityComponentBuilder<M, C> activityModule(M module);
    C build();
}
