package com.bogdankolomiets.inaccount.managers;

import com.bogdankolomiets.inaccount.model.dto.UserDTO;

/**
 * @author bogdan
 * @version 1
 * @date 06.03.17
 */

public interface LocalDataManager {

    void saveUser(UserDTO user);

    UserDTO getUser();

    String USER = "USER";
}
