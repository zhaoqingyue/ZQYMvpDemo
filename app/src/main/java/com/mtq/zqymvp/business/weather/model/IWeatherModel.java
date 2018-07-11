package com.mtq.zqymvp.business.weather.model;

import com.mtq.zqymvp.business.weather.presenter.OnWeatherListener;

/**
 * Created by zhaoqy on 2018/7/11.
 */

public interface IWeatherModel {

    /**
     * 根据天气id，获取天气信息
     */
    void getWeatherInfo(String cityId, OnWeatherListener listener);
}
