package com.yis.study.arouter;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.yis.study.R;
import com.yis.study.path.StudyRouterPath;

/**
 * Created by liuyi on 2021-03-25.
 */
@Route(path = StudyRouterPath.STUDY_ROUTER_PATH)
public class ARouterStudyActivity extends Activity {

    @Autowired(name = "name")
    String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arouter_study);
    }
}
