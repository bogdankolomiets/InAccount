package com.bogdankolomiets.inaccount.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bogdankolomiets.inaccount.R;
import com.bogdankolomiets.inaccount.di.LoginActivityComponent;
import com.bogdankolomiets.inaccount.di.activity.HasActivitySubcomponentBuilders;
import com.bogdankolomiets.inaccount.ui.common.BaseActivity;
import com.bogdankolomiets.inaccount.ui.presenter.LoginPresenter;
import com.bogdankolomiets.inaccount.ui.view.LoginView;

import javax.inject.Inject;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */

public class LoginActivity extends BaseActivity implements LoginView {

    @Inject
    LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        findViewById(R.id.btn_login).setOnClickListener(onClick -> mPresenter.onLoginClick());
    }

    @Override
    protected void injectMembers(HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders) {
        ((LoginActivityComponent.Builder) hasActivitySubcomponentBuilders.getActivityComponentBuilder(LoginActivity.class))
                .activityModule(new LoginActivityComponent.LoginActivityModule(this))
                .build()
                .injectMembers(this);
    }

    @Override
    public void openLink(String url) {

    }

    @Override
    public Context getViewContext() {
        return this;
    }
}
