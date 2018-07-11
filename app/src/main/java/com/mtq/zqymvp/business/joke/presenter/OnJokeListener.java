package com.mtq.zqymvp.business.joke.presenter;

import com.mtq.zqymvp.business.joke.bean.Joke;

/**
 * Created by zhaoqy on 2018/7/9.
 */

public interface OnJokeListener {

    void  onSuccess(Joke joke);

    void  onError();
}
