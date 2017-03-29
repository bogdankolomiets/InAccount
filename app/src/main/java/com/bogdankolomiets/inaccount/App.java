package com.bogdankolomiets.inaccount;

import android.app.Application;

import com.bogdankolomiets.inaccount.network.RetrofitFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author bogdan
 * @version 1
 * @date 06.03.17
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitFactory.INSTANCE.getApiService().auth(BuildConfig.CLIENT_ID, BuildConfig.CLIENT_SECRET, BuildConfig.REDIRECT_URI, "code")
        .enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
