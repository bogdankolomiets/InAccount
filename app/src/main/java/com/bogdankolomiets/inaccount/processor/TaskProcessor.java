package com.bogdankolomiets.inaccount.processor;

import com.bogdankolomiets.inaccount.model.Task;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bogdan
 * @version 1
 * @date 19.05.17
 */

public class TaskProcessor {
    private final List<Task> mTasks;

    private TaskProcessor() {
        mTasks = new LinkedList<>();
    }

    public void addTask(Task task) {
        mTasks.add(task);
    }

    public void addTasks(Collection<Task> tasks) {
        mTasks.addAll(tasks);
    }

    public void clear() {
        mTasks.clear();
    }

    public void removeTask(Task task) {
        mTasks.remove(task);
    }

    public void startScheduledTasks() {

    }

    public void startTask(Task task) {

    }

    public void stopScheduledTasks() {

    }

    public void stopTask(Task task) {

    }
}
