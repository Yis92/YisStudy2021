package com.yis.study.view.chongtu;

import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.yis.study.R;
import com.yis.study.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyi on 2021-03-04.
 */
public class MyChongtuActivity extends BaseActivity {

    private MyListView listView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_chongtu;
    }

    @Override
    protected void initData() {

        listView = findViewById(R.id.list_view);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("当前的名字是" + i);
        }

        ListViewAdapter adapter = new ListViewAdapter(list, this);
        listView.setAdapter(adapter);

    }
}
