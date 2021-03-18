package com.yis.study.list.adpter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yis.study.R;

import java.util.List;

/**
 * Created by liuyi on 2021-03-10.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<String> mData;

    private MyOnItemClick mMyOnItemClick;

    public void setmMyOnItemClick(MyOnItemClick mMyOnItemClick) {
        this.mMyOnItemClick = mMyOnItemClick;
    }

    public MyRecyclerViewAdapter(List<String> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.adapter_my_recycler_view, null);
        ViewHolder viewHolder = new ViewHolder(view);
        Log.i("qqq", "onCreateViewHolder。。。");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(mData.get(position));
        holder.tvName.setTag(mData.get(position));
        Log.i("qqq", "onBindViewHolder。。。" + position);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            Log.i("qqq", "view holder...");

            tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMyOnItemClick.onItemClick((String) tvName.getTag());
                }
            });
        }
    }

    public interface MyOnItemClick {
        void onItemClick(String name);
    }
}
