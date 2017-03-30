package com.bogdankolomiets.inaccount.network;

import com.bogdankolomiets.inaccount.model.RequestAccessToken;
import com.bogdankolomiets.inaccount.model.UserDTO;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author bogdan
 * @version 1
 * @date 06.03.17
 */

public interface ApiService {
    @POST("oauth/access_token")
    Single<UserDTO> getAccessToken(@Body RequestAccessToken body);
}
