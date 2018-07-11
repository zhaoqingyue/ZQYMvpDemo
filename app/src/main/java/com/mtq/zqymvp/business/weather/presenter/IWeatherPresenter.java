package com.mtq.zqymvp.business.weather.presenter;

import com.mtq.zqymvp.base.IBasePresenter;

/**
 * Created by zhaoqy on 2018/7/11.
 */

public interface IWeatherPresenter extends IBasePresenter {

    void getWeatherInfo(String cityId);
}
