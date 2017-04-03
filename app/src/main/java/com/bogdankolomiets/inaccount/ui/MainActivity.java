package com.bogdankolomiets.inaccount.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bogdankolomiets.inaccount.R;
import com.bogdankolomiets.inaccount.di.MainActivityComponent;
import com.bogdankolomiets.inaccount.di.activity.HasActivitySubcomponentBuilders;
import com.bogdankolomiets.inaccount.ui.common.BaseActivity;
import com.bogdankolomiets.inaccount.ui.presenter.MainPresenter;
import com.bogdankolomiets.inaccount.ui.view.MainView;

import javax.inject.Inject;

/**
 * @author bogdan
 * @version 1
 * @date 31.03.17
 */

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
    }

    @Override
    protected void injectMembers(HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders) {
        ((MainActivityComponent.Builder) hasActivitySubcomponentBuilders.getActivityComponentBuilder(MainView.class))
                .activityModule(new MainActivityComponent.MainActivityModule(this))
                .build()
                .injectMembers(this);
    }

    @Override
    public Context getViewContext() {
        return this;
    }
}
