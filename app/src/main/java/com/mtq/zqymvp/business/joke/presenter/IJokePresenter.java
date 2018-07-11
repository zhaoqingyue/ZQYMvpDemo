package com.mtq.zqymvp.business.joke.presenter;

import com.mtq.zqymvp.base.IBasePresenter;

/**
 * Created by zhaoqy on 2018/7/9.
 */

public interface IJokePresenter extends IBasePresenter{

    void getJokeList(String pageNum, String pageSize);
}
