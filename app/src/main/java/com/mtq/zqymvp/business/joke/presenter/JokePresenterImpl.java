package com.mtq.zqymvp.business.joke.presenter;

import com.mtq.zqymvp.business.joke.bean.Joke;
import com.mtq.zqymvp.business.joke.model.IJokeModel;
import com.mtq.zqymvp.business.joke.model.JokeModelImpl;
import com.mtq.zqymvp.business.joke.view.IJokeView;

/**
 * Created by zhaoqy on 2018/7/9.
 */

public class JokePresenterImpl implements IJokePresenter, OnJokeListener {

    private IJokeView mIJokeView;
    private IJokeModel mIJokeModel;

    public JokePresenterImpl(IJokeView jokeView) {
        mIJokeView = jokeView;
        mIJokeModel = new JokeModelImpl();
    }

    @Override
    public void getJokeList(String pageNum, String pageSize) {
        if (mIJokeView != null) {
            mIJokeView.showProgress();
        }
        mIJokeModel.getJokeList(pageNum, pageSize, this);
    }

    @Override
    public void onDestroy() {
        mIJokeView = null;
    }

    @Override
    public void onSuccess(Joke joke) {
        if (mIJokeView != null) {
            mIJokeView.hideProgress();
            mIJokeView.onSuccess(joke);
        }
    }

    @Override
    public void onFail(String msg) {
        if (mIJokeView != null) {
            mIJokeView.hideProgress();
            mIJokeView.onFail(msg);
        }
    }
}
