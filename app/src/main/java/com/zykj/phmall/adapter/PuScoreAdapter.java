package com.zykj.phmall.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseAdapter;
import com.zykj.phmall.beans.PuScoreBean;
import com.zykj.phmall.utils.TextUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 徐学坤 on 2016/9/28.
 */
public class PuScoreAdapter extends BaseAdapter<PuScoreAdapter.PuScoreHolder, PuScoreBean> {
    public PuScoreAdapter(Context context) {
        super(context);
    }

    @Override
    public int provideItemLayoutId() {
        return R.layout.ui_item_puscore;
    }

    @Override
    public PuScoreHolder createVH(View view) {
        return new PuScoreHolder(view);
    }

    @Override
    public void onBindViewHolder(PuScoreHolder holder, int position) {

        if (holder.getItemViewType() == TYPE_ITEM) {
            final PuScoreBean psb = mData.get(position);
            if (psb == null) {
                return;
            }
            TextUtil.setText(holder.tv_desc, psb.pl_desc);
            TextUtil.setText(holder.tv_time, psb.addtimetext);
            if (psb.pl_points.startsWith("-", 0)) {
                TextUtil.setText(holder.tv_points, psb.pl_points);
                holder.tv_points.setTextColor(Color.parseColor("#00FF00"));
            } else {
                TextUtil.setText(holder.tv_points, "+" + psb.pl_points);
            }
        }
    }

    class PuScoreHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Nullable
        @Bind(R.id.tv_desc)
        TextView tv_desc;
        @Nullable
        @Bind(R.id.tv_time)
        TextView tv_time;
        @Nullable
        @Bind(R.id.tv_points)
        TextView tv_points;


        PuScoreHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, this.getAdapterPosition());
            }
        }
    }
}
