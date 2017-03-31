package com.bogdankolomiets.inaccount.di.activity;

import android.app.Activity;

import com.bogdankolomiets.inaccount.ui.common.CommonView;

import dagger.MembersInjector;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */

public interface ActivityComponent<V extends Activity> extends MembersInjector<V> {
}
