package com.zykj.phmall.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseAdapter;
import com.zykj.phmall.beans.ManagerBean;
import com.zykj.phmall.utils.TextUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 徐学坤 on 2016/9/29.
 */
public class ManagerAdapter extends BaseAdapter<ManagerAdapter.ManagerHolder, ManagerBean> {
    public ManagerAdapter(Context context) {
        super(context);
    }

    @Override
    public int provideItemLayoutId() {
        return R.layout.ui_item_puscore;
    }

    @Override
    public ManagerHolder createVH(View view) {
        return new ManagerHolder(view);
    }

    @Override
    public void onBindViewHolder(ManagerHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_ITEM) {
            final ManagerBean mgb = mData.get(position);
            if (mgb == null) {
                return;
            }
            TextUtil.setText(holder.tv_desc, mgb.pl_desc);
            TextUtil.setText(holder.tv_time, mgb.addtimetext);
            if (mgb.pl_points.startsWith("-", 0)) {
                TextUtil.setText(holder.tv_points, mgb.pl_points);
                holder.tv_points.setTextColor(Color.parseColor("#00FF00"));
            } else {
                TextUtil.setText(holder.tv_points, "+" + mgb.pl_points);
            }
        }
    }

    class ManagerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Nullable
        @Bind(R.id.tv_desc)
        TextView tv_desc;
        @Nullable
        @Bind(R.id.tv_time)
        TextView tv_time;
        @Nullable
        @Bind(R.id.tv_points)
        TextView tv_points;

        ManagerHolder(View view) {
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
