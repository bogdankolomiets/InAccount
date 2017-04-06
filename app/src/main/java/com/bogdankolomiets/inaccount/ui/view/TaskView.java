package com.bogdankolomiets.inaccount.ui.view;

import com.bogdankolomiets.inaccount.ui.SearchTypeDialog;
import com.bogdankolomiets.inaccount.ui.common.CommonView;

/**
 * @author bogdan
 * @version 1
 * @date 06.04.17
 */

public interface TaskView extends CommonView {
    <D> void openTypeScreen(@SearchTypeDialog.SearchType int hashTag, SearchTypeDialog.ChangeListener<D> listener);

    void showHashTags(String data);

    void showLocation();

    void showUser();
}
