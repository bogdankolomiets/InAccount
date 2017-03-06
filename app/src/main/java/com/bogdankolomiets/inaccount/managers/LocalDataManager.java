package com.bogdankolomiets.inaccount.managers;

import com.bogdankolomiets.inaccount.User;

/**
 * @author bogdan
 * @version 1
 * @date 06.03.17
 */

public interface LocalDataManager {

    void saveUser(User user);

    User getUser();

    String USER = "USER";
}
