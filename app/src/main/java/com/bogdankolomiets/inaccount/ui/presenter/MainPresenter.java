package com.bogdankolomiets.inaccount.ui.presenter;

import android.widget.Toast;

import com.bogdankolomiets.inaccount.BasePresenter;
import com.bogdankolomiets.inaccount.di.activity.ActivityScope;
import com.bogdankolomiets.inaccount.ui.interactors.MainInteractor;
import com.bogdankolomiets.inaccount.ui.view.MainView;

import java.util.Arrays;

import javax.inject.Inject;

/**
 * @author bogdan
 * @version 1
 * @date 03.04.17
 */
@ActivityScope
public class MainPresenter extends BasePresenter<MainView, MainInteractor> {

    @Inject
    public MainPresenter(MainView view, MainInteractor interactor) {
        super(view, interactor);
    }


    public void onResume() {
        getInteractor().loadTasks().subscribe(data -> {
            getView().showTasks(data);
        },throwable -> getView().showError(throwable.getMessage()));
    }

    public void onAddTaskClicked() {
        getView().openAddNewTaskScreen();
    }
}
