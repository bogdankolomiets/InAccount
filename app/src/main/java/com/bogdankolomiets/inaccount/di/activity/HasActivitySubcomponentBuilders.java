package com.bogdankolomiets.inaccount.di.activity;

import com.bogdankolomiets.inaccount.ui.common.CommonView;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */

public interface HasActivitySubcomponentBuilders {
    ActivityComponentBuilder getActivityComponentBuilder(Class<? extends CommonView> viewClass);
}
