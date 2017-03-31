package com.bogdankolomiets.inaccount.ui.interactors;

import com.bogdankolomiets.inaccount.BuildConfig;

import javax.inject.Inject;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */

public class LoginInteractor implements Interactor {

    @Inject
    public LoginInteractor() {

    }

    public String getLoginUrl() {
        return String.format("%soauth/authorize/?client_id=%s&redirect_uri=%s&response_type=%s",
                BuildConfig.BASE_URL,
                BuildConfig.CLIENT_ID,
                BuildConfig.REDIRECT_URI,
                "code");
    }
}
