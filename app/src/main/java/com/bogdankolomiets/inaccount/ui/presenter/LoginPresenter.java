package com.bogdankolomiets.inaccount.ui.presenter;

import com.bogdankolomiets.inaccount.BasePresenter;
import com.bogdankolomiets.inaccount.di.activity.ActivityScope;
import com.bogdankolomiets.inaccount.ui.interactors.LoginInteractor;
import com.bogdankolomiets.inaccount.ui.view.LoginView;

import javax.inject.Inject;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */
@ActivityScope
public class LoginPresenter extends BasePresenter<LoginView, LoginInteractor> {

    @Inject
    public LoginPresenter(LoginView view, LoginInteractor interactor) {
        super(view, interactor);
    }

    public void onLoginClick() {
        String url = getInteractor().getLoginUrl();
        getView().openLink(url);
    }
}
