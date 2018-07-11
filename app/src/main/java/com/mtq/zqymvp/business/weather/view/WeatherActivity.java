package com.mtq.zqymvp.business.weather.view;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mtq.zqymvp.R;
import com.mtq.zqymvp.base.BaseActivity;
import com.mtq.zqymvp.business.weather.bean.Weather;
import com.mtq.zqymvp.business.weather.bean.WeatherInfo;
import com.mtq.zqymvp.business.weather.presenter.IWeatherPresenter;
import com.mtq.zqymvp.business.weather.presenter.WeatherPresenterImpl;

import butterknife.BindView;

public class WeatherActivity extends BaseActivity implements IWeatherView {

    @BindView(R.id.tv_city)
    TextView city;

    @BindView(R.id.tv_wd)
    TextView wd;

    @BindView(R.id.tv_ws)
    TextView ws;

    @BindView(R.id.tv_time)
    TextView time;

    @BindView(R.id.pb_progress)
    ProgressBar progressBar;


    private IWeatherPresenter presenter;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_weather;
    }

    @Override
    protected String getTitleName() {
        return "天气";
    }

    @Override
    protected void initData() {
        presenter = new WeatherPresenterImpl(this);
    }

    @Override
    protected void loadData() {
        // 主要城市代码：http://mobile.weather.com.cn/js/citylist.xml
        // 深圳
        String cityId = "101280601";
        presenter.getWeatherInfo(cityId);
    }

    @Override
    public void onSuccess(Weather weather) {
        if (weather != null) {
            WeatherInfo weatherInfo = weather.weatherinfo;
            city.setText("城市：" + weatherInfo.city);
            wd.setText("风向：" + weatherInfo.WD);
            ws.setText("风级：" + weatherInfo.WS);
            time.setText("发布时间：" + weatherInfo.time);
        }
    }

    @Override
    public void onFail(String msg) {
        city.setText("城市：==");
        wd.setText("风向：==");
        ws.setText("风级：==");
        time.setText("发布时间：==");
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
