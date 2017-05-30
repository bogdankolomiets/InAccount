package com.bogdankolomiets.inaccount;

import android.app.Application;
import android.content.Context;

import com.bogdankolomiets.inaccount.db.module.RealmModule;
import com.bogdankolomiets.inaccount.di.ApiModule;
import com.bogdankolomiets.inaccount.di.AppComponent;
import com.bogdankolomiets.inaccount.di.AppModule;
import com.bogdankolomiets.inaccount.di.DaggerAppComponent;
import com.bogdankolomiets.inaccount.di.activity.ActivityComponentBuilder;
import com.bogdankolomiets.inaccount.di.activity.HasActivitySubcomponentBuilders;
import com.bogdankolomiets.inaccount.ui.common.CommonView;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * @author bogdan
 * @version 1
 * @date 06.03.17
 */

public class App extends Application implements HasActivitySubcomponentBuilders {
    @Inject
    Map<Class<? extends CommonView>, Provider<ActivityComponentBuilder>> activityComponentBuilders;

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().modules(new RealmModule()).build();
        Realm.setDefaultConfiguration(configuration);
        mAppComponent = buildAppComponent();
        mAppComponent.inject(this);
    }

    public static HasActivitySubcomponentBuilders get(Context context) {
        return ((HasActivitySubcomponentBuilders) context.getApplicationContext());
    }

    protected AppComponent buildAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule(BuildConfig.BASE_URL))
                .build();
    }

    @Override
    public ActivityComponentBuilder getActivityComponentBuilder(Class<? extends CommonView> viewClass) {
        return activityComponentBuilders.get(viewClass).get();
    }
}
