package com.yis.study.xingneng;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.yis.study.R;
import com.yis.study.base.BaseActivity;
import com.yis.study.xingneng.oom.ANRActivity;
import com.yis.study.xingneng.oom.OomActivity;

/**
 * Created by liuyi on 2021-03-05.
 */
public class XingNengYouHuaActivity extends BaseActivity {

    private Button btnOom;
    private Button btnAnr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_xing_neng_you_hua;
    }

    @Override
    protected void initData() {
        btnOom = findViewById(R.id.btn_oom);
        btnAnr = findViewById(R.id.btn_anr);

        btnOom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(XingNengYouHuaActivity.this, OomActivity.class));
            }
        });

        btnAnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(XingNengYouHuaActivity.this, ANRActivity.class));
            }
        });
    }
}
