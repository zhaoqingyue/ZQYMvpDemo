package com.mtq.zqymvp.business.joke.model;

import com.blankj.utilcode.util.LogUtils;
import com.mtq.zqymvp.business.joke.bean.Joke;
import com.mtq.zqymvp.business.joke.presenter.OnJokeListener;
import com.mtq.zqymvp.retrofit.ApiService;
import com.mtq.zqymvp.retrofit.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by zhaoqy on 2018/7/9.
 */

public class JokeModelImpl implements IJokeModel {

    private static final String JOKE_SERVER_URL ="http://api.jisuapi.com/xiaohua/";
    private static final String SORT ="addtime";
    private static final String APPKEY ="9814b57c706d0a23";

    @Override
    public void getJokeList(String pageNum, String pageSize, final OnJokeListener listener) {
        Retrofit retrofit = ApiClient.retrofit(JOKE_SERVER_URL);
        ApiService request = retrofit.create(ApiService.class);
        Call<Joke> call = request.getJokeList(pageNum, pageSize, SORT, APPKEY);
        call.enqueue(new Callback<Joke>() {

            @Override
            public void onResponse(Call<Joke> call, Response<Joke> response) {
                LogUtils.e("ZQY", " === onResponse ===");
                if (response != null) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFail("返回结果为空");
                }
            }

            @Override
            public void onFailure(Call<Joke> call, Throwable throwable) {
                LogUtils.e("ZQY", " === onFailure ===");
                listener.onFail(throwable.toString());
            }
        });
    }
}
