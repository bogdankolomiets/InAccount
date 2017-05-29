package com.bogdankolomiets.inaccount.ui.common;

import android.content.Context;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 30.03.17
 */

public interface CommonView {
    Context getViewContext();

    void showError(String message);
}
