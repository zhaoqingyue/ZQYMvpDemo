package com.mtq.zqymvp.retrofit;

import com.blankj.utilcode.util.LogUtils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhaoqy on 2018/7/9.
 */

public class ApiClient {

    public static final boolean DEBUG = true;

    public static Retrofit retrofit(String baseUrl) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {

                @Override
                public void log(String message) {
                    // 打印retrofit日志
                    LogUtils.i("RetrofitLog","retrofitBack= "+ message);
                }
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            // 设置 Debug Log 模式
            builder.addInterceptor(loggingInterceptor);
        }
        OkHttpClient okHttpClient = builder.build();

        // 创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("http://fy.iciba.com/")
                .baseUrl(baseUrl)                                   // 设置网络请求Url
                .addConverterFactory(GsonConverterFactory.create()) // 设置使用Gson解析
                .client(okHttpClient)
                .build();

        return retrofit;
    }
}
