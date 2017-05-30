package com.bogdankolomiets.inaccount.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.bogdankolomiets.inaccount.R;
import com.bogdankolomiets.inaccount.di.TaskActivityComponent;
import com.bogdankolomiets.inaccount.di.activity.HasActivitySubcomponentBuilders;
import com.bogdankolomiets.inaccount.model.Action;
import com.bogdankolomiets.inaccount.model.ActionVO;
import com.bogdankolomiets.inaccount.ui.common.BaseActivity;
import com.bogdankolomiets.inaccount.ui.presenter.TaskPresenter;
import com.bogdankolomiets.inaccount.ui.view.TaskView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * @author bogdan
 * @version 1
 * @date 03.04.17
 */

public class TaskActivity extends BaseActivity implements TaskView {

    //Criteria for user selection
    @BindView(R.id.etSubscribersCount)
    EditText etSubscribersCount;
    @BindView(R.id.etSubscriptionsCount)
    EditText etSubscriptionsCount;

    //Search Type
    @BindView(R.id.tvSearchType)
    TextView tvSearchType;

    @Inject
    TaskPresenter mPresenter;

    @OnCheckedChanged(R.id.cbHasProfilePhoto)
    public void onHasProfileCheckedChanged(CheckBox cb, boolean checked) {
        mPresenter.onHasProfilePhotoCheckedChanged(checked);
    }

    @OnClick(R.id.tvActionsAndPriority)
    public void onActionsAndPriorityClicked(View view) {
        mPresenter.onActionsAndPriorityClicked();
    }

    @OnClick(R.id.vLocation)
    public void onLocationClick(View view) {
        mPresenter.onLocationClicked();
    }

    @OnClick(R.id.vHashTag)
    public void onHashTagClick(View view) {
        mPresenter.onHashTagClicked();
    }

    @OnClick(R.id.vUser)
    public void onUserClick(View view) {
        mPresenter.onUserClicked();
    }

    @OnClick(R.id.btn_start)
    public void onStartClick(View view) {
        mPresenter.onStartClicked();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_activity);
        ButterKnife.bind(this);
        mPresenter.onSubscribersCountChanges(etSubscribersCount);
        mPresenter.onSubscriptionsCountChanges(etSubscriptionsCount);
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

    @Override
    public void openActionAndPriorityScreen(List<ActionVO> data) {
        ActionsAndPriorityDialog dialog = ActionsAndPriorityDialog.newInstance(data, mPresenter::onConfirmActionsAndPriority);
        dialog.show(getSupportFragmentManager(), null);
    }

    @Override
    public void showTasksScreen() {
        onBackPressed();
    }
}
