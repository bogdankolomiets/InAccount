package com.bogdankolomiets.inaccount.model;

import com.bogdankolomiets.inaccount.ui.SearchTypeDialog;

/**
 * @author bogdan
 * @version 1
 * @date 5/31/17
 */

public class SearchType {
    private final  @SearchTypeDialog.SearchType int mSearchType;
    private final String mQuery;

    public SearchType(@SearchTypeDialog.SearchType int searchType, String query) {
        mSearchType = searchType;
        mQuery = query;
    }

    public int getSearchType() {
        return mSearchType;
    }

    public String getQuery() {
        return mQuery;
    }
}
