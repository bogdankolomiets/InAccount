package com.bogdankolomiets.inaccount.managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.bogdankolomiets.inaccount.BuildConfig;
import com.bogdankolomiets.inaccount.User;
import com.google.gson.Gson;

/**
 * @author bogdan
 * @version 1
 * @date 06.03.17
 */

public class LocalDataManagerImpl implements LocalDataManager {
    private static LocalDataManagerImpl sInstance = null;
    private SharedPreferences mPreferences;

    private LocalDataManagerImpl(Context context) {
        mPreferences = context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);
    }

    public static LocalDataManagerImpl getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LocalDataManagerImpl.class) {
                if (sInstance == null) {
                    sInstance = new LocalDataManagerImpl(context);
                }
            }
        }

        return sInstance;
    }

    @Override
    public void saveUser(User user) {
        String serializedUser = new Gson().toJson(user);
        mPreferences.edit()
                .putString(USER, serializedUser)
                .apply();
    }

    @Override
    public User getUser() {
        String serializedUser = mPreferences.getString(USER, null);

        if (serializedUser != null) {
            return new Gson().fromJson(serializedUser, User.class);
        }

        return null;
    }
}
