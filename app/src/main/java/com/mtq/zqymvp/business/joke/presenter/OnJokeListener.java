package com.mtq.zqymvp.business.joke.presenter;

import com.mtq.zqymvp.base.IBaseOnListener;
import com.mtq.zqymvp.business.joke.bean.Joke;

/**
 * Created by zhaoqy on 2018/7/9.
 */

public interface OnJokeListener extends IBaseOnListener {

    void  onSuccess(Joke joke);
}
