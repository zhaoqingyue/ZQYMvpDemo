package com.mtq.zqymvp.business.login.view;

import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mtq.zqymvp.R;
import com.mtq.zqymvp.base.BaseActivity;
import com.mtq.zqymvp.business.login.presenter.ILoginPresenter;
import com.mtq.zqymvp.business.login.presenter.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView {

    @BindView(R.id.et_username)
    EditText username;

    @BindView(R.id.et_password)
    EditText password;

    @BindView(R.id.pb_progress)
    ProgressBar progressBar;

    private ILoginPresenter presenter;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_login;
    }

    @Override
    protected String getTitleName() {
        return "模拟登录";
    }

    @Override
    protected void initData() {
        presenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void loadData() {

    }

    @OnClick({R.id.btn_login})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login: {
                String name = username.getText().toString();
                String pwd = password.getText().toString();
                presenter.login(name, pwd);
                break;
            }
        }
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onUserNameError() {
        Toast.makeText(this,"用户名不能为空！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPasswordError() {
        Toast.makeText(this,"密码不能为空！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
        // 登录成功处理，比如：页面跳转
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
