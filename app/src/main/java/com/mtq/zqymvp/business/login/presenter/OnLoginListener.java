package com.mtq.zqymvp.business.login.presenter;

/**
 * Created by zhaoqy on 2018/7/6.
 */

public interface OnLoginListener {

    void onSuccess();

    void onUserNameError();

    void onPasswordError();
}
