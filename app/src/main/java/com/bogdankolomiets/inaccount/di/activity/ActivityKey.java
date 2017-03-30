package com.bogdankolomiets.inaccount.di.activity;

import android.app.Activity;

import com.bogdankolomiets.inaccount.ui.common.CommonView;

import dagger.MapKey;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */
@MapKey
public @interface ActivityKey {
    Class<? extends CommonView> value();
}
