package com.bogdankolomiets.inaccount.ui;

/**
 * @author bogdan
 * @version 1
 * @date 31.03.17
 */

public interface OAuthDialogListener {
    void onComplete(String code);
    void onError(String error);
}
