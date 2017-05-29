package com.bogdankolomiets.inaccount.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bogdankolomiets.inaccount.R;
import com.bogdankolomiets.inaccount.di.MainActivityComponent;
import com.bogdankolomiets.inaccount.di.activity.HasActivitySubcomponentBuilders;
import com.bogdankolomiets.inaccount.model.Task;
import com.bogdankolomiets.inaccount.ui.common.BaseActivity;
import com.bogdankolomiets.inaccount.ui.presenter.MainPresenter;
import com.bogdankolomiets.inaccount.ui.view.MainView;

import java.util.List;

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
        findViewById(R.id.addTask).setOnClickListener(onClick -> mPresenter.onAddTaskClicked());
    }

    @Override
    protected void injectMembers(HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders) {
        ((MainActivityComponent.Builder) hasActivitySubcomponentBuilders.getActivityComponentBuilder(MainView.class))
                .activityModule(new MainActivityComponent.MainActivityModule(this))
                .build()
                .injectMembers(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void openAddNewTaskScreen() {
        Intent intent = new Intent(this, TaskActivity.class);
        startActivity(intent);
    }

    @Override
    public void showTasks(List<Task> data) {

    }
}
