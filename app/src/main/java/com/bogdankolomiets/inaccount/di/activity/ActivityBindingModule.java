package com.bogdankolomiets.inaccount.di.activity;

import com.bogdankolomiets.inaccount.di.LoginActivityComponent;
import com.bogdankolomiets.inaccount.ui.view.LoginView;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */
@Module (
        subcomponents = {
                LoginActivityComponent.class
        }
)
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(LoginView.class)
    public abstract ActivityComponentBuilder loginActivityComponentBuilder(LoginActivityComponent.Builder impl);
}
