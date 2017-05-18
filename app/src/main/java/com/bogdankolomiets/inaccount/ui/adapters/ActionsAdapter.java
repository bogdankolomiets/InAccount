package com.bogdankolomiets.inaccount.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.bogdankolomiets.inaccount.R;
import com.bogdankolomiets.inaccount.model.Action;
import com.bogdankolomiets.inaccount.model.ActionVO;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author bogdan
 * @version 1
 * @date 18.05.17
 */

public class ActionsAdapter extends RecyclerView.Adapter<ActionsAdapter.Holder> {
    private List<ActionVO> mActions;

    public ActionsAdapter() {
        mActions = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.action_layout, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        ActionVO action = mActions.get(position);
        holder.tvAction.setText(action.getName());
        holder.etPriority.setText(String.valueOf(action.getPriority()));
        holder.cbEnabled.setChecked(action.isEnabled());
        holder.cbEnabled.setOnCheckedChangeListener((button, checked) -> {
            mActions.get(position).setEnabled(checked);
        });
    }

    @Override
    public int getItemCount() {
        return mActions.size();
    }

    public void show(List<ActionVO> data) {
        mActions.clear();
        mActions.addAll(data);
        notifyDataSetChanged();
    }

    public List<ActionVO> get() {
        return mActions;
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvAction)
        TextView tvAction;
        @BindView(R.id.etPriority)
        EditText etPriority;
        @BindView(R.id.cbEnabled)
        CheckBox cbEnabled;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
