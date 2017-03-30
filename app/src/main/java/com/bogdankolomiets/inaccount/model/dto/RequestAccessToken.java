package com.bogdankolomiets.inaccount.model.dto;

import com.google.gson.annotations.SerializedName;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */

public class RequestAccessToken {
    @SerializedName("client_id")
    public String clientId;

    @SerializedName("client_secret")
    public String clientSecret;

    @SerializedName("grant_type")
    public String grantType;

    @SerializedName("redirect_uri")
    public String redirectUri;

    @SerializedName("code")
    public String code;

    public RequestAccessToken() {

    }

    public RequestAccessToken(String clientId, String clientSecret, String grantType, String redirectUri, String code) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.grantType = grantType;
        this.redirectUri = redirectUri;
        this.code = code;
    }
}
