package com.bogdankolomiets.inaccount.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bogdankolomiets.inaccount.R;
import com.bogdankolomiets.inaccount.model.Task;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author bogdan
 * @version 1
 * @date 29.05.17
 */

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.Holder> {
    private List<Task> mTasks;

    public TasksAdapter() {
        mTasks = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task_layout, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Task task = mTasks.get(position);
        holder.tvTaskUUID.setText(task.getUUID());
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    public void showData(List<Task> data) {
        mTasks.clear();
        mTasks.addAll(data);
        notifyDataSetChanged();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_task_uuid)
        TextView tvTaskUUID;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
