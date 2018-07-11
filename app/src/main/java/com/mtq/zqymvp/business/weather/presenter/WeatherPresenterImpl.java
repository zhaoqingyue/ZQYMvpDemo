package com.mtq.zqymvp.business.weather.presenter;

import com.mtq.zqymvp.business.weather.bean.Weather;
import com.mtq.zqymvp.business.weather.model.IWeatherModel;
import com.mtq.zqymvp.business.weather.model.WeatherModelImpl;
import com.mtq.zqymvp.business.weather.view.IWeatherView;

/**
 * Created by zhaoqy on 2018/7/11.
 */

public class WeatherPresenterImpl implements IWeatherPresenter, OnWeatherListener {

    IWeatherView mIWeatherView;
    IWeatherModel mIWeatherModel;

    public WeatherPresenterImpl(IWeatherView iWeatherView) {
        mIWeatherView = iWeatherView;
        mIWeatherModel = new WeatherModelImpl();
    }

    @Override
    public void getWeatherInfo(String cityId) {
        if (mIWeatherView != null) {
            mIWeatherView.showProgress();
        }
        mIWeatherModel.getWeatherInfo(cityId, this);
    }

    @Override
    public void onDestroy() {
        if (mIWeatherView != null) {
            mIWeatherView = null;
        }
    }

    @Override
    public void onSuccess(Weather weather) {
        if (mIWeatherView != null) {
            mIWeatherView.hideProgress();
            mIWeatherView.onSuccess(weather);
        }
    }

    @Override
    public void onFail(String msg) {
        if (mIWeatherView != null) {
            mIWeatherView.hideProgress();
            mIWeatherView.onFail(msg);
        }
    }
}
