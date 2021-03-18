package com.yis.study.list.adpter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.yis.study.R

/**
 * Created by liuyi on 2021-03-11.
 */
class MyListViewStudyAdapter(val mData: List<String>) : BaseAdapter() {

    override fun getItem(position: Int): Any {
        return mData.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position as Long
    }

    override fun getCount(): Int {
        return mData.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val tvname:TextView
        if (convertView == null) {
            view = View.inflate(parent?.context, R.layout.adapter_my_list_view_study, null)
            tvname = view.findViewById(R.id.tvName)
        } else {
            view = convertView
        }



        return view
    }

}