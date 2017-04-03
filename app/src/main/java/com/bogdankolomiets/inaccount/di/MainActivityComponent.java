package com.bogdankolomiets.inaccount.di;

import com.bogdankolomiets.inaccount.di.activity.ActivityComponent;
import com.bogdankolomiets.inaccount.di.activity.ActivityComponentBuilder;
import com.bogdankolomiets.inaccount.di.activity.ActivityModule;
import com.bogdankolomiets.inaccount.di.activity.ActivityScope;
import com.bogdankolomiets.inaccount.ui.MainActivity;
import com.bogdankolomiets.inaccount.ui.view.MainView;

import dagger.Module;
import dagger.Subcomponent;

/**
 * @author bogdan
 * @version 1
 * @date 03.04.17
 */
@ActivityScope
@Subcomponent(
        modules = MainActivityComponent.MainActivityModule.class
)
public interface MainActivityComponent extends ActivityComponent<MainActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<MainActivityModule, MainActivityComponent> {

    }

    @Module
    class MainActivityModule extends ActivityModule<MainView> {

        public MainActivityModule(MainView view) {
            super(view);
        }
    }
}
