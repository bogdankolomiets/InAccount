package com.bogdankolomiets.inaccount.di;

import com.bogdankolomiets.inaccount.di.activity.ActivityComponent;
import com.bogdankolomiets.inaccount.di.activity.ActivityComponentBuilder;
import com.bogdankolomiets.inaccount.di.activity.ActivityModule;
import com.bogdankolomiets.inaccount.di.activity.ActivityScope;
import com.bogdankolomiets.inaccount.ui.view.LoginView;

import dagger.Module;
import dagger.Subcomponent;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */
@ActivityScope
@Subcomponent(
        modules = LoginActivityComponent.LoginActivityModule.class
)
public interface LoginActivityComponent extends ActivityComponent<LoginView> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<LoginActivityModule, LoginActivityComponent> {

    }
    @Module
    class LoginActivityModule extends ActivityModule<LoginView> {

        public LoginActivityModule(LoginView view) {
            super(view);
        }
    }
        }
