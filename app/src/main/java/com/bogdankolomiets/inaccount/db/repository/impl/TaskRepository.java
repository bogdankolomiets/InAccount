package com.bogdankolomiets.inaccount.db.repository.impl;

import com.bogdankolomiets.inaccount.db.entity.TaskEntity;
import com.bogdankolomiets.inaccount.db.repository.ITaskRepository;
import com.bogdankolomiets.inaccount.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;

/**
 * @author bogdan
 * @version 1
 * @date 29.05.17
 */

public class TaskRepository implements ITaskRepository {
    private Realm mDatabase;

    @Inject
    public TaskRepository(Realm database) {
        mDatabase = database;
    }

    @Override
    public Observable<Void> saveTask(Task task) {
        return Observable.create((ObservableOnSubscribe<Void>) e -> {
            try {
                mDatabase.beginTransaction();
                TaskEntity taskEntity = mDatabase.createObject(TaskEntity.class);
                taskEntity.setUUID(UUID.randomUUID().toString());
                taskEntity.setSubscribersCount(task.getSubscribersCount());
                taskEntity.setSubscriptionCount(task.getSubscroptionsCount());
                taskEntity.setActions(task.getActions());
                taskEntity.setSearchType(task.getSearchType());
                taskEntity.setHasProfilePhoto(task.isHasProfilePhoto());
                mDatabase.commitTransaction();
            } catch (Exception ex) {
                e.onError(ex);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<List<TaskEntity>> getTasks() {
        return Observable.fromIterable(mDatabase.where(TaskEntity.class).findAll())
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<TaskEntity> getTaskByUUID(String UUID) {
        return Observable.just(mDatabase.where(TaskEntity.class).equalTo("UUID", UUID).findFirst())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
