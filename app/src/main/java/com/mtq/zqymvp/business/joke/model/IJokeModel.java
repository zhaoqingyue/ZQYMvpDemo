package com.mtq.zqymvp.business.joke.model;

import com.mtq.zqymvp.business.joke.presenter.OnJokeListener;

/**
 * Created by zhaoqy on 2018/7/9.
 */

public interface IJokeModel {

    /**
     * 获取笑话内容
     *
     * @param pageNum   请求哪一页
     *
     * @param pageSize    每页返回多少条
     *
     * @param listener    回调监听
     *
     */
    void getJokeList(String pageNum, String pageSize, OnJokeListener listener);
}
