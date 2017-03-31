package com.bogdankolomiets.inaccount.di.activity;

import com.bogdankolomiets.inaccount.ui.common.CommonView;

import dagger.Module;
import dagger.Provides;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */
@Module
public abstract class ActivityModule<V extends CommonView> {
    private final V mView;

    public ActivityModule(V view) {
        mView = view;
    }

    @Provides
    @ActivityScope
    public V provideView() {
        return mView;
    }
}
