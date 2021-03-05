package com.yis.study.view.chongtu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yis.study.R;

import java.util.List;

/**
 * Created by liuyi on 2021-03-04.
 */
public class ListViewAdapter extends BaseAdapter {

    private List<String> list;
    private Context context;

    public ListViewAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_list_view, null);

        TextView tvName = view.findViewById(R.id.tv_name);

        tvName.setText(list.get(position));

        return view;
    }
}
