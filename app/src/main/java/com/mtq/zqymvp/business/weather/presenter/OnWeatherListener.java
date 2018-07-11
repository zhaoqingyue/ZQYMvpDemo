package com.mtq.zqymvp.business.weather.presenter;

import com.mtq.zqymvp.base.IBaseOnListener;
import com.mtq.zqymvp.business.weather.bean.Weather;

/**
 * Created by zhaoqy on 2018/7/11.
 */

public interface OnWeatherListener extends IBaseOnListener {

    void onSuccess(Weather weather);
}
