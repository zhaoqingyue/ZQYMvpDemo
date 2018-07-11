package com.mtq.zqymvp.business.weather.view;

import com.mtq.zqymvp.base.IBaseView;
import com.mtq.zqymvp.business.weather.bean.Weather;

/**
 * Created by zhaoqy on 2018/7/6.
 */

public interface IWeatherView extends IBaseView {

    void onSuccess(Weather weather);

    void onFail(String msg);
}
