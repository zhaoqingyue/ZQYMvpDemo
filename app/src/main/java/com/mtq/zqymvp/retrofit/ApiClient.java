package com.mtq.zqymvp.retrofit;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhaoqy on 2018/7/9.
 */

public class ApiClient {

    public static Retrofit retrofit(String baseUrl) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {

            @Override
            public void log(String message) {
                Log.i("Retrofit","retrofitBack= "+ message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);
        OkHttpClient okHttpClient = builder.build();

        // 创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)                                   // 设置网络请求Url
                .addConverterFactory(GsonConverterFactory.create()) // 设置使用Gson解析
                .client(okHttpClient)
                .build();

        return retrofit;
    }
}
