package com.bogdankolomiets.inaccount.di;

import com.bogdankolomiets.inaccount.App;
import com.bogdankolomiets.inaccount.managers.LocalDataManager;
import com.bogdankolomiets.inaccount.managers.LocalDataManagerImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */
@Module
public class AppModule {
    private final App mApplication;

    public AppModule(App application) {
        mApplication = application;
    }


    @Singleton
    @Provides
    LocalDataManager provideLocalDataManager() {
        return LocalDataManagerImpl.getInstance(mApplication);
    }
}
