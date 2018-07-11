package com.mtq.zqymvp.retrofit;

import com.mtq.zqymvp.business.joke.bean.Joke;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zhaoqy on 2018/7/9.
 */

public interface Api {

    // public static final String REQUEST_SERVER_URL ="http://api.jisuapi.com/xiaohua/";
    // public static final String APPKEY ="9814b57c706d0a23";

    // http://api.jisuapi.com/xiaohua/text?pagenum=10&pagesize=3&sort=addtime&appkey=9814b57c706d0a23
    @GET("text")
    Call<Joke> getJokeList(@Query("pagenum") String pagenum,
                           @Query("pagesize") String pagesize,
                           @Query("sort") String sort,
                           @Query("appkey") String appkey);
}
