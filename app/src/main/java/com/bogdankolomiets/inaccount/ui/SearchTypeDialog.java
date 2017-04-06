package com.bogdankolomiets.inaccount.ui;

import android.os.Bundle;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author bogdan
 * @version 1
 * @date 06.04.17
 */

public class SearchTypeDialog extends android.support.v4.app.DialogFragment {
    public static final String TYPE = "TYPE";

    public static final int HASH_TAG = 1;
    public static final int LOCATION = 2;
    public static final int USER = 3;

    @IntDef({HASH_TAG, LOCATION, USER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SearchType{}

    private @SearchType int mType;

    public static SearchTypeDialog newInstance(@SearchType int type) {
        SearchTypeDialog instance = new SearchTypeDialog();
        Bundle args = new Bundle();
        args.putInt(TYPE, type);

        instance.setArguments(args);
        return instance;
    }
}
