package com.bogdankolomiets.inaccount.di;

import com.bogdankolomiets.inaccount.di.activity.ActivityComponent;
import com.bogdankolomiets.inaccount.di.activity.ActivityComponentBuilder;
import com.bogdankolomiets.inaccount.di.activity.ActivityModule;
import com.bogdankolomiets.inaccount.di.activity.ActivityScope;
import com.bogdankolomiets.inaccount.ui.TaskActivity;
import com.bogdankolomiets.inaccount.ui.view.TaskView;

import dagger.Module;
import dagger.Subcomponent;

/**
 * @author bogdan
 * @version 1
 * @date 06.04.17
 */
@ActivityScope
@Subcomponent(
        modules = TaskActivityComponent.TaskActivityModule.class
)
public interface TaskActivityComponent extends ActivityComponent<TaskActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<TaskActivityModule, TaskActivityComponent>{}

    @Module
    class TaskActivityModule extends ActivityModule<TaskView> {

        public TaskActivityModule(TaskView view) {
            super(view);
        }
    }
}
