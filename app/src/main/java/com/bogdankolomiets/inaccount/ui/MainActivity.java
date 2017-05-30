package com.bogdankolomiets.inaccount.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bogdankolomiets.inaccount.R;
import com.bogdankolomiets.inaccount.di.MainActivityComponent;
import com.bogdankolomiets.inaccount.di.activity.HasActivitySubcomponentBuilders;
import com.bogdankolomiets.inaccount.model.Task;
import com.bogdankolomiets.inaccount.ui.adapters.TasksAdapter;
import com.bogdankolomiets.inaccount.ui.common.BaseActivity;
import com.bogdankolomiets.inaccount.ui.presenter.MainPresenter;
import com.bogdankolomiets.inaccount.ui.view.MainView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author bogdan
 * @version 1
 * @date 31.03.17
 */

public class MainActivity extends BaseActivity implements MainView {
    @BindView(R.id.rv_tasks)
    RecyclerView rvTasks;

    @Inject
    MainPresenter mPresenter;

    private TasksAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        ButterKnife.bind(this);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TasksAdapter();
        rvTasks.setAdapter(mAdapter);
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
        mAdapter.showData(data);
    }
}
