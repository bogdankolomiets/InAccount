package com.bogdankolomiets.inaccount.db;

import android.arch.persistence.room.RoomDatabase;

/**
 * @author bogdan
 * @version 1
 * @date 22.05.17
 */
@android.arch.persistence.room.Database(entities = {UserEntity.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract UserDAO userDao();
}
