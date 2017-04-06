package com.bogdankolomiets.inaccount.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bogdankolomiets.inaccount.R;
import com.bogdankolomiets.inaccount.di.TaskActivityComponent;
import com.bogdankolomiets.inaccount.di.activity.HasActivitySubcomponentBuilders;
import com.bogdankolomiets.inaccount.ui.common.BaseActivity;
import com.bogdankolomiets.inaccount.ui.presenter.TaskPresenter;
import com.bogdankolomiets.inaccount.ui.view.TaskView;

import javax.inject.Inject;

/**
 * @author bogdan
 * @version 1
 * @date 03.04.17
 */

public class TaskActivity extends BaseActivity implements TaskView {
    private LinearLayout vHashTag;
    private LinearLayout vLocation;
    private LinearLayout vUser;
    TextView tvSearchType;

    @Inject
    TaskPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_activity);
        tvSearchType = (TextView) findViewById(R.id.tvSearchType);
        vHashTag = (LinearLayout) findViewById(R.id.vHashTag);
        vHashTag.setOnClickListener(onClick -> mPresenter.onHashTagClicked());
        vLocation = (LinearLayout) findViewById(R.id.vLocation);
        vLocation.setOnClickListener(onClick -> mPresenter.onLocationClicked());
        vUser = (LinearLayout) findViewById(R.id.vUser);
        vUser.setOnClickListener(onClick -> mPresenter.onUserClicked());
    }

    @Override
    protected void injectMembers(HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders) {
        ((TaskActivityComponent.Builder) hasActivitySubcomponentBuilders.getActivityComponentBuilder(TaskView.class))
                .activityModule(new TaskActivityComponent.TaskActivityModule(this))
                .build()
                .injectMembers(this);
    }

    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    public <D> void openTypeScreen(@SearchTypeDialog.SearchType int type, SearchTypeDialog.ChangeListener<D> listener) {
        SearchTypeDialog<D> dialog = SearchTypeDialog.newInstance(type);
        dialog.setupChangeListener(listener);
        dialog.show(getSupportFragmentManager(), null);
    }

    @Override
    public void showHashTags(String data) {
        tvSearchType.setVisibility(View.VISIBLE);
        tvSearchType.setText("HashTags\n" + data);
    }

    @Override
    public void showLocation() {
        tvSearchType.setVisibility(View.VISIBLE);
        tvSearchType.setText("Location\n");
    }

    @Override
    public void showUser() {
        tvSearchType.setVisibility(View.VISIBLE);
        tvSearchType.setText("User\n");
    }
}
