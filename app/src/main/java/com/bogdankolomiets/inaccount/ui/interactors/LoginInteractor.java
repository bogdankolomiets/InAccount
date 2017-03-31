package com.bogdankolomiets.inaccount.ui.interactors;

import com.bogdankolomiets.inaccount.BuildConfig;
import com.bogdankolomiets.inaccount.managers.LocalDataManager;
import com.bogdankolomiets.inaccount.model.dto.RequestAccessToken;
import com.bogdankolomiets.inaccount.model.dto.UserDTO;
import com.bogdankolomiets.inaccount.network.ApiService;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */
public class LoginInteractor implements Interactor {
    private final ApiService mApiService;
    private final LocalDataManager mLocalDataManager;

    @Inject
    public LoginInteractor(ApiService apiService, LocalDataManager localDataManager) {
        mApiService = apiService;
        mLocalDataManager = localDataManager;
    }

    public String getLoginUrl() {
        return String.format("%soauth/authorize/?client_id=%s&redirect_uri=%s&response_type=%s",
                BuildConfig.BASE_URL,
                BuildConfig.CLIENT_ID,
                BuildConfig.REDIRECT_URI,
                "code");
    }

    public Single<UserDTO> getAccessToken(String code) {
        RequestAccessToken requestAccessToken = new RequestAccessToken();
        requestAccessToken.clientId = BuildConfig.CLIENT_ID;
        requestAccessToken.clientSecret = BuildConfig.CLIENT_SECRET;
        requestAccessToken.redirectUri = BuildConfig.REDIRECT_URI;
        requestAccessToken.grantType = "authorization_code";
        requestAccessToken.code = code;

        return mApiService.getAccessToken(
                BuildConfig.CLIENT_ID,
                BuildConfig.CLIENT_SECRET,
                "authorization_code",
                BuildConfig.REDIRECT_URI,
                code).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public void saveSession(UserDTO userDTO) {
        mLocalDataManager.saveUser(userDTO);
    }

    public boolean hasSession() {
        return mLocalDataManager.getUser() != null;
    }

    public UserDTO getSession() {
        return mLocalDataManager.getUser();
    }
}
