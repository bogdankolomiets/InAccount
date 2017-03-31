package com.bogdankolomiets.inaccount.ui.view;

import com.bogdankolomiets.inaccount.ui.OAuthDialogListener;
import com.bogdankolomiets.inaccount.ui.common.CommonView;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */

public interface LoginView extends CommonView {
    void openLink(String url, OAuthDialogListener oAuthDialogListener);
}
