package com.yis.study.http.okhttp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.yis.study.R;
import com.yis.study.http.retrofit.bean.GongzhonghaoResp;
import com.yis.study.http.retrofit.bean.RegisterResp;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 使用原生 okhttp 进行网络请求 demo
 * Created by liuyi on 2021-02-20.
 */
public class OkhttpActivity extends Activity {

    private Button btnGet;
    private Button btnPostRegister;
    private Button btnPostLogin;
    private TextView tvContent;

    private Handler handler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                tvContent.setText((String) msg.obj);
            }
        }
    };

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
     *
     */
    private void get() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.wanandroid.com/wxarticle/chapters/json")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                //当前为子线程

                String body = response.body().string();
                Gson gson = new Gson();
                GongzhonghaoResp resp = gson.fromJson(body, GongzhonghaoResp.class);

                List<GongzhonghaoResp.DataBean> data = resp.getData();

                StringBuilder sb = new StringBuilder();
                for (GongzhonghaoResp.DataBean name : data) {
                    sb.append(name.getName() + "\n");
                }

                Message message = Message.obtain();
                message.what = 1;
                message.obj = sb.toString();

                handler.sendMessage(message);
            }
        });
    }

    /**
     * post 请求demo
     */
    private void postRegister() {
        OkHttpClient okHttpClient = new OkHttpClient();

        //json 请求格式未成功
//        MediaType JSON = MediaType.get("application/json; charset=utf-8");
//
//        RegisterReq registerReq = new RegisterReq();
//        registerReq.setUsername("zhangsan");
//        registerReq.setPassword("123456");
//        registerReq.setRepassword("123456");
//        RequestBody requestBody = RequestBody.create(JSON, new Gson().toJson(registerReq));

        // from 表单方式
        RequestBody formBody = new FormBody.Builder()
                .add("username", "test7777")
                .add("password", "123456")
                .add("repassword", "123456")
                .build();

        Request request = new Request.Builder()
                .url("https://www.wanandroid.com/user/register")
                .post(formBody).build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                //当前为子线程

                String body = response.body().string();
                Gson gson = new Gson();
                RegisterResp resp = gson.fromJson(body, RegisterResp.class);

                String content;
                if (resp.getErrorCode() == 0) {
                    content = "注册成功..\n用户名为" + resp.getData().getUsername() + "\n密码为:" + resp.getData().getPassword();
                } else {
                    content = resp.getErrorMsg();
                }
                Message message = Message.obtain();
                message.what = 1;
                message.obj = content;

                handler.sendMessage(message);
            }
        });
    }

    /**
     * post 请求demo
     */
    private void postLogin() {
        OkHttpClient okHttpClient = new OkHttpClient();

        //json 请求格式未成功
//        MediaType JSON = MediaType.get("application/json; charset=utf-8");
//
//        RegisterReq registerReq = new RegisterReq();
//        registerReq.setUsername("zhangsan");
//        registerReq.setPassword("123456");
//        registerReq.setRepassword("123456");
//        RequestBody requestBody = RequestBody.create(JSON, new Gson().toJson(registerReq));

        // from 表单方式
        RequestBody formBody = new FormBody.Builder()
                .add("username", "test7777")
                .add("password", "123456")
                .build();

        Request request = new Request.Builder()
                .url("https://www.wanandroid.com/user/login")
                .post(formBody).build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                //当前为子线程

                String body = response.body().string();
                Gson gson = new Gson();
                RegisterResp resp = gson.fromJson(body, RegisterResp.class);

                String content;
                if (resp.getErrorCode() == 0) {
                    content = "登录成功..用户名为" + resp.getData().getUsername();
                } else {
                    content = resp.getErrorMsg();
                }
                Message message = Message.obtain();
                message.what = 1;
                message.obj = content;

                handler.sendMessage(message);
            }
        });
    }
}
