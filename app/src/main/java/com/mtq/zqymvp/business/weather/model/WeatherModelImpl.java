package com.mtq.zqymvp.business.weather.model;

import com.blankj.utilcode.util.LogUtils;
import com.mtq.zqymvp.business.weather.bean.Weather;
import com.mtq.zqymvp.business.weather.presenter.OnWeatherListener;
import com.mtq.zqymvp.retrofit.ApiClient;
import com.mtq.zqymvp.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by zhaoqy on 2018/7/11.
 */

public class WeatherModelImpl implements IWeatherModel {

    private static final String WEATHER_SERVER_URL = "http://www.weather.com.cn/";

    @Override
    public void getWeatherInfo(String cityId, final OnWeatherListener listener) {
        Retrofit retrofit = ApiClient.retrofit(WEATHER_SERVER_URL);
        ApiService request = retrofit.create(ApiService.class);
        Call<Weather> call = request.getWeatherInfo(cityId);
        call.enqueue(new Callback<Weather>() {

            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                LogUtils.e("ZQY", " === onResponse ===");
                if (response != null) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFail("返回结果为空");
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable throwable) {
                LogUtils.e("ZQY", " === onFailure ===");
                listener.onFail(throwable.toString());
            }
        });
    }
}
