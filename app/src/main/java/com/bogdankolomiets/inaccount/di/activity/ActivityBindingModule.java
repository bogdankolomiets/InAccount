package com.bogdankolomiets.inaccount.di.activity;

import com.bogdankolomiets.inaccount.di.LoginActivityComponent;
import com.bogdankolomiets.inaccount.di.MainActivityComponent;
import com.bogdankolomiets.inaccount.di.TaskActivityComponent;
import com.bogdankolomiets.inaccount.ui.view.LoginView;
import com.bogdankolomiets.inaccount.ui.view.MainView;
import com.bogdankolomiets.inaccount.ui.view.TaskView;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */
@Module(
        subcomponents = {
                LoginActivityComponent.class,
                MainActivityComponent.class,
                TaskActivityComponent.class
        }
)
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(LoginView.class)
    public abstract ActivityComponentBuilder loginActivityComponentBuilder(LoginActivityComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(MainView.class)
    public abstract ActivityComponentBuilder mainActivityComponentBuilder(MainActivityComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(TaskView.class)
    public abstract ActivityComponentBuilder taskActivityComponentBuilder(TaskActivityComponent.Builder impl);
}
