package com.mtq.zqymvp.retrofit;

import com.mtq.zqymvp.business.joke.bean.Joke;
import com.mtq.zqymvp.business.weather.bean.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by zhaoqy on 2018/7/9.
 */

public interface ApiService {

    /**
     * 获取joke列表
     * http://api.jisuapi.com/xiaohua/text?pagenum=1&pagesize=3&sort=addtime&appkey=9814b57c706d0a23
     *
     * http://api.jisuapi.com/xiaohua/text?pagenum=1&pagesize=10
     *
     */
    //@Headers({"sort:addtime", "appkey:9814b57c706d0a23"})
    //@Headers("appkey:9814b57c706d0a23")
    @GET("text")
    Call<Joke> getJokeList(@Query("pagenum") String pagenum,
                           @Query("pagesize") String pagesize,
                           @Query("sort") String sort,
                           @Query("appkey") String appkey);

    /**
     * 获取天气信息
     * http://www.weather.com.cn/adat/sk/101280601.html
     */
    @GET("adat/sk/{cityId}.html")
    Call<Weather> getWeatherInfo(@Path("cityId") String cityId);
}
