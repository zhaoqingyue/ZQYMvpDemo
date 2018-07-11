package com.mtq.zqymvp.business.joke.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mtq.zqymvp.R;
import com.mtq.zqymvp.business.joke.bean.JokeInfo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JokeAdapter extends BaseAdapter {

	private ArrayList<JokeInfo> list;
	private Context mContext;

	public JokeAdapter(Context context, ArrayList<JokeInfo> list) {
		this.mContext = context;
		this.list = list;
	}

	public void setList(ArrayList<JokeInfo> list) {
		this.list = list;
	}

	@Override
	public int getCount() {
		return list == null ? 0 : list.size();
	}

	@Override
	public JokeInfo getItem(int position) {
		JokeInfo item = null;
		if (null != list) {
			item = list.get(position);
		}
		return item;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		JokeInfo item = getItem(position);
		if (item == null)
			return null;

		ViewHolder holder;
		if (view != null) {
			holder = (ViewHolder) view.getTag();
		} else {
			view = LayoutInflater.from(mContext).inflate(R.layout.item_joke, parent, false);
			holder = new ViewHolder(view);
			view.setTag(holder);
		}

		holder.content.setText(item.content);
		holder.time.setText(item.addtime);

		return view;
	}

	static class ViewHolder {

		@BindView(R.id.tv_content)
		TextView content;

		@BindView(R.id.tv_time)
		TextView time;


		public ViewHolder(View view) {
			ButterKnife.bind(this, view);
		}
	}
}
