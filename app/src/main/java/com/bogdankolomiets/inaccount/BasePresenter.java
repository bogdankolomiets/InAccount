package com.bogdankolomiets.inaccount;

import com.bogdankolomiets.inaccount.ui.common.CommonView;
import com.bogdankolomiets.inaccount.ui.interactors.Interactor;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 06.03.17
 */

public class BasePresenter<V extends CommonView, I extends Interactor> {
    private final V mView;
    private final I mInteractor;

    public BasePresenter(V view, I interactor) {
        mView = view;
        mInteractor = interactor;
    }

    public V getView() {
        return mView;
    }

    public I getInteractor() {
        return mInteractor;
    }
}
