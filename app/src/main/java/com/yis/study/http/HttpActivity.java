package com.yis.study.http;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.yis.study.R;
import com.yis.study.http.retrofit.RetrofitActivity;

/**
 * 网络请求demo：Okhttp & Retrofit
 * Created by liuyi on 2021-02-20.
 */
public class HttpActivity extends Activity {

    private Button btnOkhttp;
    private Button btnRetrofit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        btnOkhttp = findViewById(R.id.btn_okhttp);
        btnRetrofit = findViewById(R.id.btn_retrofit);

        btnOkhttp.setOnClickListener(view -> {

        });

        btnRetrofit.setOnClickListener(view ->
                startActivity(new Intent(HttpActivity.this, RetrofitActivity.class)));
    }
}
