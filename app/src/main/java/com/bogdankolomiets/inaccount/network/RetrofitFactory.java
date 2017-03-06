package com.bogdankolomiets.inaccount.network;

import com.bogdankolomiets.inaccount.BuildConfig;
import com.bogdankolomiets.inaccount.network.ApiService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author bogdan
 * @version 1
 * @date 06.03.17
 */

public enum RetrofitFactory {
    INSTANCE;

    ApiService mApiService = createApiService();

    public ApiService getApiService() {
        return mApiService;
    }

    private ApiService createApiService() {
        return getRetrofit().create(ApiService.class);
    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(createHttpClient())
                .build();
    }

    private OkHttpClient createHttpClient() {
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(logger)
                .build();
    }
}
