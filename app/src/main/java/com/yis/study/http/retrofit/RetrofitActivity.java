package com.yis.study.http.retrofit;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.yis.study.R;
import com.yis.study.http.retrofit.bean.GongzhonghaoResp;
import com.yis.study.http.retrofit.bean.RegisterResp;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liuyi on 2021-02-20.
 */
public class RetrofitActivity extends Activity {

    private Button btnGet;
    private Button btnPostRegister;
    private Button btnPostLogin;
    private TextView tvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        btnGet = findViewById(R.id.btn_get);
        btnPostRegister = findViewById(R.id.btn_post_register);
        btnPostLogin = findViewById(R.id.btn_post_login);
        tvContent = findViewById(R.id.tv_content);

        btnGet.setOnClickListener(view -> get());

        btnPostRegister.setOnClickListener(view -> postRegister());

        btnPostLogin.setOnClickListener(view -> postLogin());
    }

    /**
     * get 请求demo
     */
    public void get() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com")
                .client(genericClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);
        Call<GongzhonghaoResp> call = gitHubService.chapters();
        call.enqueue(new Callback<GongzhonghaoResp>() {
            @Override
            public void onResponse(Call<GongzhonghaoResp> call, Response<GongzhonghaoResp> response) {
                GongzhonghaoResp resp = response.body();
                if (resp.getErrorCode() == 0) {
                    List<GongzhonghaoResp.DataBean> data = resp.getData();

                    StringBuilder sb = new StringBuilder();
                    for (GongzhonghaoResp.DataBean name : data) {
                        sb.append(name.getName() + "\n");
                    }

                    tvContent.setText(sb.toString());
                }
            }

            @Override
            public void onFailure(Call<GongzhonghaoResp> call, Throwable t) {
                Log.i("qqq", "失败：" + t.getMessage());
            }
        });
    }

    /**
     * post 请求demo
     */
    public void postRegister() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);
        Call<RegisterResp> call = gitHubService.register("liuyi", "123456", "123456");
        call.enqueue(new Callback<RegisterResp>() {
            @Override
            public void onResponse(Call<RegisterResp> call, Response<RegisterResp> response) {
                RegisterResp resp = response.body();
                if (resp.getErrorCode() == 0) {
                    tvContent.setText("注册..用户名为" + resp.getData().getUsername() + "\n密码为:" + resp.getData().getPassword());
                } else {
                    tvContent.setText(resp.getErrorMsg());
                }
            }

            @Override
            public void onFailure(Call<RegisterResp> call, Throwable t) {
                tvContent.setText(t.getMessage());
            }
        });
    }

    /**
     * post 请求demo
     */
    public void postLogin() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);
        Call<RegisterResp> call = gitHubService.login("liuyi", "123456");
        call.enqueue(new Callback<RegisterResp>() {
            @Override
            public void onResponse(Call<RegisterResp> call, Response<RegisterResp> response) {
                RegisterResp resp = response.body();
                if (resp.getErrorCode() == 0) {
                    tvContent.setText("登录成功..用户名为" + resp.getData().getUsername());
                }
            }

            @Override
            public void onFailure(Call<RegisterResp> call, Throwable t) {
                tvContent.setText(t.getMessage());
            }
        });
    }

    /**
     * 使用自定义的 OkHttpClient
     */
    public OkHttpClient genericClient() {
        // 添加日志拦截器
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();
    }
}
