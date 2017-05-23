package com.bogdankolomiets.inaccount.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author bogdan
 * @version 1
 * @date 22.05.17
 */
@Entity(tableName = "users")
public class UserEntity {
    @ColumnInfo(name = "access_token")
    public String accessToken;
    @Embedded(prefix = "user_")
    public Data data;

    public static class Data {
        @PrimaryKey
        public String id;

        @ColumnInfo(name = "name")
        public String userName;

        @ColumnInfo(name = "full_name")
        public String fullName;

        @ColumnInfo(name = "profile_picture")
        public String profilePicture;

        public Data(String id, String userName, String fullName, String profilePicture) {
            this.id = id;
            this.userName = userName;
            this.fullName = fullName;
            this.profilePicture = profilePicture;
        }
    }
}
