package com.bogdankolomiets.inaccount.managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.bogdankolomiets.inaccount.BuildConfig;
import com.bogdankolomiets.inaccount.model.Task;
import com.bogdankolomiets.inaccount.model.dto.UserDTO;
import com.google.gson.Gson;

import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    public void saveUser(UserDTO user) {
        String serializedUser = new Gson().toJson(user);
        mPreferences.edit()
                .putString(USER, serializedUser)
                .apply();
    }

    @Override
    public UserDTO getUser() {
        String serializedUser = mPreferences.getString(USER, null);

        if (serializedUser != null) {
            return new Gson().fromJson(serializedUser, UserDTO.class);
        }

        return null;
    }

}
