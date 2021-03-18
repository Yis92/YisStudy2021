package com.yis.study.list;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yis.study.R;
import com.yis.study.base.BaseActivity;
import com.yis.study.list.adpter.DiffCallBack;
import com.yis.study.list.adpter.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by liuyi on 2021-03-10.
 */
public class MyRecyclerViewActivity extends BaseActivity {

    @BindView(R.id.btn_change)
    Button btnChange;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_recycler_view;
    }

    @Override
    protected void initData() {
        List<String> oldList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            oldList.add("第" + i + "条数据");
        }
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(oldList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setmMyOnItemClick(new MyRecyclerViewAdapter.MyOnItemClick() {
            @Override
            public void onItemClick(String name) {
                Toast.makeText(MyRecyclerViewActivity.this, "=" + name, Toast.LENGTH_LONG).show();
            }
        });
        // 加大 CacheView 缓存
        recyclerView.setItemViewCacheSize(3);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> newList = new ArrayList<>();
                newList = oldList;
                newList.set(0, "局部刷新吧");

                DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffCallBack(oldList, newList), true);
                diffResult.dispatchUpdatesTo(adapter);
                adapter.notifyDataSetChanged();
                //别忘了将新数据给Adapter
//                oldList = newList;
//                adapter.setDatas(oldList);
            }
        });
    }
}
