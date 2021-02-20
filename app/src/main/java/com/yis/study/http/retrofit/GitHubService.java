package com.yis.study.http.retrofit;

import com.yis.study.http.retrofit.bean.GongzhonghaoResp;
import com.yis.study.http.retrofit.bean.RegisterResp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by liuyi on 2021-02-20.
 */
public interface GitHubService {

    /**
     * 获取公众号列表
     *
     * @return
     */
    @GET("wxarticle/chapters/json")
    Call<GongzhonghaoResp> chapters();

    /**
     * 注册
     *
     * @return
     */
    @FormUrlEncoded
    @POST("user/register")
    Call<RegisterResp> register(@Field("username") String username, @Field("password") String password,
                                @Field("repassword") String repassword);

    /**
     * 登录
     *
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    Call<RegisterResp> login(@Field("username") String username, @Field("password") String password);
}
