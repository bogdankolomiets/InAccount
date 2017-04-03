package com.bogdankolomiets.inaccount.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bogdankolomiets.inaccount.R;
import com.bogdankolomiets.inaccount.di.activity.HasActivitySubcomponentBuilders;
import com.bogdankolomiets.inaccount.ui.common.BaseActivity;

/**
 * @author bogdan
 * @version 1
 * @date 03.04.17
 */

public class TaskActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_activity);
    }

    @Override
    protected void injectMembers(HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders) {

    }
}
