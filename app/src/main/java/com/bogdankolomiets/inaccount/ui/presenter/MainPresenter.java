package com.bogdankolomiets.inaccount.ui.presenter;

import com.bogdankolomiets.inaccount.BasePresenter;
import com.bogdankolomiets.inaccount.di.activity.ActivityScope;
import com.bogdankolomiets.inaccount.ui.interactors.MainInteractor;
import com.bogdankolomiets.inaccount.ui.view.MainView;

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


}
