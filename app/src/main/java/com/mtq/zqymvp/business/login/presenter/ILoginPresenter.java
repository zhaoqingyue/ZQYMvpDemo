package com.mtq.zqymvp.business.login.presenter;

import com.mtq.zqymvp.base.IBasePresenter;

/**
 * Created by zhaoqy on 2018/7/6.
 */

public interface ILoginPresenter extends IBasePresenter {

    void login(String username, String password);
}
