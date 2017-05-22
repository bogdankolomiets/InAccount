package com.bogdankolomiets.inaccount.network;

import com.bogdankolomiets.inaccount.model.dto.UserDTO;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author bogdan
 * @version 1
 * @date 06.03.17
 */

public interface ApiService {
    @POST("oauth/access_token")
    @FormUrlEncoded
    Single<UserDTO> getAccessToken(@Field("client_id") String clientId,
                                   @Field("client_secret") String clientSecret,
                                   @Field("grant_type") String grantType,
                                   @Field("redirect_uri") String redirectUri,
                                   @Field("code") String code);


}
