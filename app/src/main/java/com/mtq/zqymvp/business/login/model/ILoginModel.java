package com.mtq.zqymvp.business.login.model;

import com.mtq.zqymvp.business.login.presenter.OnLoginListener;

/**
 * Created by zhaoqy on 2018/7/6.
 */

public interface ILoginModel {

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @param listener 回调接口
     */
    void login(String username, String password, OnLoginListener listener);
}
