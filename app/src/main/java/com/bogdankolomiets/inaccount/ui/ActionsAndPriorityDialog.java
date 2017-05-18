package com.bogdankolomiets.inaccount.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bogdankolomiets.inaccount.R;
import com.bogdankolomiets.inaccount.model.ActionVO;
import com.bogdankolomiets.inaccount.ui.adapters.ActionsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author bogdan
 * @version 1
 * @date 18.05.17
 */

public class ActionsAndPriorityDialog extends DialogFragment {
    @BindView(R.id.rvActions)
    RecyclerView rvActions;

    private ActionsAdapter mActionsAdapter;
    private List<ActionVO> mData = new ArrayList<>();
    private OnResultListener mOnResultListener = new OnResultListener() {
        @Override
        public void onOkClicked(List<ActionVO> actions) {
            dismissAllowingStateLoss();
        }
    };

    @OnClick(R.id.btn_ok)
    public void onOkClick(View view) {
        mOnResultListener.onOkClicked(mActionsAdapter.get());
        dismissAllowingStateLoss();
    }

    @OnClick(R.id.btn_cancel)
    public void onCancelClicked(View view) {
        dismissAllowingStateLoss();
    }

    public static ActionsAndPriorityDialog newInstance() {
        return new ActionsAndPriorityDialog();
    }

    public static ActionsAndPriorityDialog newInstance(List<ActionVO> actions, OnResultListener onResultListener) {
        ActionsAndPriorityDialog dialog = new ActionsAndPriorityDialog();
        dialog.addData(actions);
        dialog.mOnResultListener = onResultListener;
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_actions_and_priority, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        rvActions.setLayoutManager(new LinearLayoutManager(getContext()));
        mActionsAdapter = new ActionsAdapter();
        rvActions.setAdapter(mActionsAdapter);
        mActionsAdapter.show(mData);
    }

    private void addData(List<ActionVO> data) {
        mData.clear();
        mData.addAll(data);
    }

    public interface OnResultListener {
        void onOkClicked(List<ActionVO> actions);
    }

}
