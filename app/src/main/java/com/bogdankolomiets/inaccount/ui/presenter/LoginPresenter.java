package com.bogdankolomiets.inaccount.ui.presenter;

import android.widget.Toast;

import com.bogdankolomiets.inaccount.BasePresenter;
import com.bogdankolomiets.inaccount.di.activity.ActivityScope;
import com.bogdankolomiets.inaccount.ui.OAuthDialogListener;
import com.bogdankolomiets.inaccount.ui.interactors.LoginInteractor;
import com.bogdankolomiets.inaccount.ui.view.LoginView;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */
@ActivityScope
public class LoginPresenter extends BasePresenter<LoginView, LoginInteractor> implements OAuthDialogListener {

    @Inject
    public LoginPresenter(LoginView view, LoginInteractor interactor) {
        super(view, interactor);
    }

    public void onLoginClick() {
        String url = getInteractor().getLoginUrl();
        getView().openLink(url, this);
    }

    @Override
    public void onComplete(String code) {
        Disposable disposable = getInteractor().getAccessToken(code).subscribe(response -> {
            Toast.makeText(getView().getViewContext(), response.toString(), Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public void onError(String error) {
        Toast.makeText(getView().getViewContext(), error, Toast.LENGTH_LONG).show();
    }
}
