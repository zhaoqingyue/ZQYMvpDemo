package com.mtq.zqymvp.business.joke.view;

import com.mtq.zqymvp.base.IBaseView;
import com.mtq.zqymvp.business.joke.bean.Joke;

/**
 * Created by zhaoqy on 2018/7/9.
 */

public interface IJokeView extends IBaseView {

    void onSuccess(Joke joke);

    void onError();
}
