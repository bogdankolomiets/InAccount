package com.bogdankolomiets.inaccount.di;

import com.bogdankolomiets.inaccount.App;
import com.bogdankolomiets.inaccount.di.activity.ActivityBindingModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                ApiModule.class,
                ActivityBindingModule.class
        }
)
public interface AppComponent {
    App inject(App app);
}
