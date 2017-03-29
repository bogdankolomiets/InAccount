package com.bogdankolomiets.inaccount.network;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author bogdan
 * @version 1
 * @date 06.03.17
 */

public interface ApiService {
    @POST("oauth/authorize")
    Call<Void> auth(@Query("client_id") String clientId,
                    @Query("client_secret") String clientSecret,
                    @Query("redirect_uri") String redirectUri,
                    @Query("response_type") String responseType);
}
