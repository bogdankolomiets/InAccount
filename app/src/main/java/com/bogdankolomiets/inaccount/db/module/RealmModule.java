package com.bogdankolomiets.inaccount.db.module;

import com.bogdankolomiets.inaccount.db.entity.TaskEntity;

/**
 * @author bogdan
 * @version 1
 * @date 29.05.17
 */
@io.realm.annotations.RealmModule(classes = {TaskEntity.class})
public class RealmModule {
}
