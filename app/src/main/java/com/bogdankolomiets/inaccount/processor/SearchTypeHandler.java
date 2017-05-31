package com.bogdankolomiets.inaccount.processor;


import com.bogdankolomiets.inaccount.model.SearchType;
import com.bogdankolomiets.inaccount.network.ApiService;

import javax.inject.Inject;

import io.reactivex.Observable;

import static com.bogdankolomiets.inaccount.ui.SearchTypeDialog.HASH_TAG;
import static com.bogdankolomiets.inaccount.ui.SearchTypeDialog.LOCATION;
import static com.bogdankolomiets.inaccount.ui.SearchTypeDialog.USER;

/**
 * @author bogdan
 * @version 1
 * @date 5/31/17
 */

class SearchTypeHandler {
    private final ApiService mApiService;

    @Inject
    SearchTypeHandler(ApiService apiService) {
        mApiService = apiService;
    }

    Observable<Void> search(SearchType searchType) {
        switch (searchType.getSearchType()) {
            case HASH_TAG:
                return null;
            case LOCATION:
                return null;
            case USER:
                return null;
            default:
                return null;
        }
    }
}
