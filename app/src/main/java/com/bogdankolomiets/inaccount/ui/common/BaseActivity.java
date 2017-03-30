package com.bogdankolomiets.inaccount.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bogdankolomiets.inaccount.App;
import com.bogdankolomiets.inaccount.di.activity.HasActivitySubcomponentBuilders;

import javax.inject.Inject;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent();
    }

    protected void setupComponent() {
        injectMembers(App.get(this));
    }

    protected abstract void injectMembers(HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders);
}
