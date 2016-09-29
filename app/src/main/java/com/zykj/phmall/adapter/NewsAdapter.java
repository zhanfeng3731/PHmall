package com.zykj.phmall.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseAdapter;
import com.zykj.phmall.beans.AnnounceBean;
import com.zykj.phmall.beans.MessageBean;
import com.zykj.phmall.utils.TextUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by csh
 * Created date 2016/9/28.
 * Description 公告适配器
 */

public class NewsAdapter extends BaseAdapter<NewsAdapter.NewsHolder, AnnounceBean> {

    public NewsAdapter(Context context) {
        super(context);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.NewsHolder holder, int position) {
        if(holder.getItemViewType() == TYPE_ITEM){
            final AnnounceBean ann = mData.get(position);
            if(ann == null) {
                return;
            }
            TextUtil.setText(holder.tv_title, ann.article_title);
            TextUtil.setText(holder.tv_time, ann.article_time);
        }
    }

    @Override
    public int provideItemLayoutId() {
        return R.layout.ui_item_news;
    }

    @Override
    public NewsAdapter.NewsHolder createVH(View view) {
        return new NewsHolder(view);
    }

    class NewsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Nullable
        @Bind(R.id.tv_title)
        TextView tv_title;
        @Nullable
        @Bind(R.id.tv_time)
        TextView tv_time;

        NewsHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, this.getAdapterPosition());
            }
        }
    }
}