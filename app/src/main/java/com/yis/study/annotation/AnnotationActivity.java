package com.yis.study.annotation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.yis.study.R;

/**
 * Created by liuyi on 2021-02-18.
 */
public class AnnotationActivity extends Activity {

    @InjectView(R.id.tv_content)
    private TextView tvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);
        InjectUtils.injectView(this);
        tvContent.setText("注解反射");
    }
}
