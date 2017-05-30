package com.bogdankolomiets.inaccount.ui.interactors;

import com.bogdankolomiets.inaccount.db.entity.ActionEntity;
import com.bogdankolomiets.inaccount.db.repository.impl.TaskRepository;
import com.bogdankolomiets.inaccount.model.Action;
import com.bogdankolomiets.inaccount.model.Task;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * @author bogdan
 * @version 1
 * @date 03.04.17
 */

public class MainInteractor implements Interactor {
    private final TaskRepository mTaskRepository;

    @Inject
    public MainInteractor(TaskRepository taskRepository) {
        mTaskRepository = taskRepository;
    }

    public Single<List<Task>> loadTasks() {
        return mTaskRepository.getTasks().map(taskEntities -> Observable.fromIterable(taskEntities)
                .map(taskEntity -> {
                    Task task = new Task(taskEntity.getUUID());
                    task.setSearchType(taskEntity.getSearchType());
                    task.setHasProfilePhoto(taskEntity.isHasProfilePhoto());
                    List<Action> actions = new ArrayList<>();
                    for (ActionEntity actionEntity : taskEntity.getActions()) {
                        Action action = new Action(Action.Type.valueOf(actionEntity.getType()), actionEntity.getPriority());
                        actions.add(action);
                    }
                    task.setActions(actions);
                    task.setSubscribersCount(taskEntity.getSubscribersCount());
                    task.setSubscroptionsCount(taskEntity.getSubscriptionCount());
                    return task;
                }).toList().blockingGet());
    }
}
