package com.bogdankolomiets.inaccount;

/**
 * @author bogdan
 * @version 1
 * @date 06.03.17
 */

public class User {
    private String mLogin;
    private String mPassword;

    public User(String login, String password) {
        mLogin = login;
        mPassword = password;
    }

    public String getLogin() {
        return mLogin;
    }

    public String getPassword() {
        return mPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "mLogin='" + mLogin + '\'' +
                ", mPassword='" + mPassword + '\'' +
                '}';
    }
}
