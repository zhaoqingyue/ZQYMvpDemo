package com.mtq.zqymvp.business.login.presenter;

import com.mtq.zqymvp.business.login.model.ILoginModel;
import com.mtq.zqymvp.business.login.model.LoginModelImpl;
import com.mtq.zqymvp.business.login.view.ILoginView;

/**
 * Created by zhaoqy on 2018/7/6.
 */

public class LoginPresenterImpl implements ILoginPresenter, OnLoginListener {

    private ILoginView mILoginView;
    private ILoginModel mILoginModel;

    public LoginPresenterImpl(ILoginView iloginView) {
        mILoginView = iloginView;
        mILoginModel = new LoginModelImpl();
    }

    @Override
    public void login(String username, String password) {
        if (mILoginView != null) {
            mILoginView.showProgress();
        }
        mILoginModel.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        mILoginView = null;
    }

    @Override
    public void onSuccess() {
        if (mILoginView != null) {
            mILoginView.hideProgress();
            mILoginView.onSuccess();
        }
    }

    @Override
    public void onFail(String msg) {
        if (mILoginView != null) {
            mILoginView.hideProgress();
            mILoginView.onFail(msg);
        }
    }
}
