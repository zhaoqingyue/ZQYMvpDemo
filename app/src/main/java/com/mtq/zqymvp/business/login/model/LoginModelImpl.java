package com.mtq.zqymvp.business.login.model;

import android.os.Handler;
import android.text.TextUtils;

import com.mtq.zqymvp.business.login.presenter.OnLoginListener;

/**
 * Created by zhaoqy on 2018/7/6.
 */

public class LoginModelImpl implements ILoginModel {

    @Override
    public void login(final String username, final String password, final OnLoginListener listener) {

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (TextUtils.isEmpty(username)){
                    listener.onFail("用户名不能为空！");
                } else if (TextUtils.isEmpty(password)){
                    listener.onFail("密码不能为空！");
                } else {
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
