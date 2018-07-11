package com.mtq.zqymvp.business.joke.view;

import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.mtq.zqymvp.R;
import com.mtq.zqymvp.base.BaseActivity;
import com.mtq.zqymvp.business.joke.adapter.JokeAdapter;
import com.mtq.zqymvp.business.joke.bean.Joke;
import com.mtq.zqymvp.business.joke.bean.JokeInfo;
import com.mtq.zqymvp.business.joke.bean.JokeResult;
import com.mtq.zqymvp.business.joke.presenter.IJokePresenter;
import com.mtq.zqymvp.business.joke.presenter.JokePresenterImpl;

import java.util.ArrayList;

import butterknife.BindView;

public class JokeActivity extends BaseActivity implements IJokeView {

    public static final String  PAGE_NUM           = "1";
    public static final String  PAGE_SIZE          = "10";

    @BindView(R.id.listView)
    ListView listView;

    @BindView(R.id.tv_empty)
    TextView empty;

    @BindView(R.id.pb_progress)
    ProgressBar progressBar;

    private JokeAdapter adapter;
    private ArrayList<JokeInfo> mJokeInfoList;
    private IJokePresenter presenter;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_joke;
    }

    @Override
    protected String getTitleName() {
        return "笑话";
    }

    @Override
    protected void initData() {
        presenter = new JokePresenterImpl(this);

        mJokeInfoList = new ArrayList<JokeInfo>();
        adapter = new JokeAdapter(this, mJokeInfoList);
        listView.setAdapter(adapter);
    }

    @Override
    protected void loadData() {
        presenter.getJokeList(PAGE_NUM, PAGE_SIZE);
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
    public void onFail(String msg) {
        LogUtils.e("ZQY", " === 请求失败 === " + msg);
        listView.setEmptyView(empty);
    }

    @Override
    public void onSuccess(Joke joke) {
        if (joke != null) {
            JokeResult result = joke.result;
            if (result != null) {
                ArrayList<JokeInfo> jokeInfoList = result.list;
                mJokeInfoList.addAll(jokeInfoList);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
