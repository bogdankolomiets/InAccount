package com.bogdankolomiets.inaccount.db.repository;

import com.bogdankolomiets.inaccount.db.entity.TaskEntity;
import com.bogdankolomiets.inaccount.model.Task;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * @author bogdan
 * @version 1
 * @date 29.05.17
 */

public interface ITaskRepository {

    Observable<Void> saveTask(Task task);

    Single<List<TaskEntity>> getTasks();

    Observable<TaskEntity> getTaskByUUID(String UUID);
}
