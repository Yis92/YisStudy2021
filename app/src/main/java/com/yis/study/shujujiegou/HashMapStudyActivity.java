package com.yis.study.shujujiegou;

import com.yis.study.R;
import com.yis.study.base.BaseActivity;

import java.util.HashMap;

/**
 * Created by liuyi on 2021-03-23.
 */
public class HashMapStudyActivity extends BaseActivity {


    @Override
    protected  int getLayoutId() {
        return R.layout.activity_hash_map_study;
    }

    @Override
    protected void initData() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("1","1");
    }
}
