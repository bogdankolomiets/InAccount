package com.bogdankolomiets.inaccount.ui.view;

import com.bogdankolomiets.inaccount.model.Task;
import com.bogdankolomiets.inaccount.ui.common.CommonView;

import java.util.List;

/**
 * @author bogdan
 * @version 1
 * @date 03.04.17
 */

public interface MainView extends CommonView {
    void openAddNewTaskScreen();

    void showTasks(List<Task> data);
}
