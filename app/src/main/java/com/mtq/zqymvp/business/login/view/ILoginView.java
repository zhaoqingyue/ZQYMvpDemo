package com.mtq.zqymvp.business.login.view;

import com.mtq.zqymvp.base.IBaseView;

/**
 * Created by zhaoqy on 2018/7/6.
 */

public interface ILoginView extends IBaseView {

    void onUserNameError();

    void onPasswordError();

    void onSuccess();
}
