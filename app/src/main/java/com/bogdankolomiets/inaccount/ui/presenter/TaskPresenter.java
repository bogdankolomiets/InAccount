package com.bogdankolomiets.inaccount.ui.presenter;

import com.bogdankolomiets.inaccount.BasePresenter;
import com.bogdankolomiets.inaccount.di.activity.ActivityScope;
import com.bogdankolomiets.inaccount.ui.SearchTypeDialog;
import com.bogdankolomiets.inaccount.ui.interactors.TaskInteractor;
import com.bogdankolomiets.inaccount.ui.view.TaskView;

import javax.inject.Inject;

/**
 * @author bogdan
 * @version 1
 * @date 06.04.17
 */
@ActivityScope
public class TaskPresenter extends BasePresenter<TaskView, TaskInteractor> {

    @Inject
    public TaskPresenter(TaskView view, TaskInteractor interactor) {
        super(view, interactor);
    }

    public void onHashTagClicked() {
        getView().openTypeScreen(SearchTypeDialog.HASH_TAG, (SearchTypeDialog.ChangeListener<String>) result -> {
            getView().showHashTags(result.getData());
        });
    }

    public void onLocationClicked() {
        getView().showLocation();
    }

    public void onUserClicked() {
        getView().showUser();
    }
}