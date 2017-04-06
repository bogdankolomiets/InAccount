package com.bogdankolomiets.inaccount.model;

/**
 * @author bogdan
 * @version 1
 * @date 06.04.17
 */

public class SearchTypeResult<D> {
    private D mData;

    public SearchTypeResult(D data) {
        mData = data;
    }

    public D getData() {
        return mData;
    }
}
