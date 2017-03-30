package com.bogdankolomiets.inaccount.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */

public class UserDTO {
    @SerializedName("access_token")
    public String accessToken;
    @SerializedName("user")
    public Data data;

    public class Data {
        @SerializedName("id")
        public String id;

        @SerializedName("username")
        public String userName;

        @SerializedName("full_name")
        public String fullName;

        @SerializedName("profile_picture")
        public String profilePicture;
    }
}
