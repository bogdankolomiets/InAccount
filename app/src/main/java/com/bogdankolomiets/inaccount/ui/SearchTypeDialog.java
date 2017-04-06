package com.bogdankolomiets.inaccount.ui;

import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.bogdankolomiets.inaccount.R;
import com.bogdankolomiets.inaccount.model.SearchTypeResult;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author bogdan
 * @version 1
 * @date 06.04.17
 */

public class SearchTypeDialog<D> extends DialogFragment {
    public static final String TYPE = "TYPE";

    public static final int HASH_TAG = 1;
    public static final int LOCATION = 2;
    public static final int USER = 3;

    @IntDef({HASH_TAG, LOCATION, USER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SearchType {
    }

    private int mType;
    private ChangeListener<D> mListener;

    public static <D> SearchTypeDialog<D> newInstance(@SearchType int type) {
        SearchTypeDialog<D> instance = new SearchTypeDialog<D>();
        Bundle args = new Bundle();
        args.putInt(TYPE, type);

        instance.setArguments(args);
        return instance;
    }

    public void setupChangeListener(ChangeListener<D> listener) {
        mListener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null && args.containsKey(TYPE)) {
            mType = args.getInt(TYPE);
        } else {
            throw new IllegalArgumentException("Search type not setted");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        switch (mType) {
            case HASH_TAG:
                return inflater.inflate(R.layout.dialog_type_hash_tag, container, false);
            case LOCATION:
                return inflater.inflate(R.layout.dialog_type_location, container, false);
            case USER:
                return inflater.inflate(R.layout.dialog_type_user, container, false);
            default:
                throw new IllegalArgumentException("Unknown search type");
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        switch (mType) {
            case HASH_TAG:
                initHashTagViewComponents(view);
                break;
            case LOCATION:
                initLocationViewComponents(view);
                break;
            case USER:
                initUserViewComponents(view);
                break;
        }
    }

    private void initHashTagViewComponents(View rootView) {
        EditText etHashTags = (EditText) rootView.findViewById(R.id.tv_hash_tags);
        rootView.findViewById(R.id.btn_ok).setOnClickListener(onClick -> {
            if (mListener != null) {
                String data = etHashTags.getText().toString();
                SearchTypeResult<String> result = new SearchTypeResult<>(data);
                mListener.onChange((SearchTypeResult<D>) result);
                dismissAllowingStateLoss();
            }
        });
        rootView.findViewById(R.id.btn_cancel).setOnClickListener(onClick -> dismissAllowingStateLoss());
    }

    private void initLocationViewComponents(View rootView) {

    }

    private void initUserViewComponents(View rootView) {

    }

    public interface ChangeListener<D> {
        void onChange(SearchTypeResult<D> result);
    }
}
