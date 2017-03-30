package com.bogdankolomiets.inaccount.di.activity;

import com.bogdankolomiets.inaccount.ui.common.CommonView;

import dagger.MembersInjector;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */

public interface ActivityComponent<V extends CommonView> extends MembersInjector<V> {
}
