package com.mtq.zqymvp;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.mtq.zqymvp.base.BaseActivity;
import com.mtq.zqymvp.business.joke.view.JokeActivity;
import com.mtq.zqymvp.business.login.view.LoginActivity;
import com.mtq.zqymvp.business.weather.view.WeatherActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_des)
    TextView des;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected String getTitleName() {
        return getResources().getString(R.string.app_name);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected boolean isHasNaviIcon() {
        return false;
    }

    @OnClick({R.id.btn_login, R.id.btn_joke, R.id.btn_weather})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login: {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_joke: {
                Intent intent = new Intent(this, JokeActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_weather: {
                Intent intent = new Intent(this, WeatherActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
