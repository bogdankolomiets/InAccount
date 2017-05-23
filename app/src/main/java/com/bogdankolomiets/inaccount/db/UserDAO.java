package com.bogdankolomiets.inaccount.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

/**
 * @author bogdan
 * @version 1
 * @date 22.05.17
 */
@Dao
public abstract class UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(UserDAO userDAO);

    @Query("SELECT * FROM users")
    public abstract UserDAO getUserDao();

    @Delete
    public abstract void delete();
}
