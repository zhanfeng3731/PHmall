package com.zykj.phmall.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseAdapter;
import com.zykj.phmall.beans.DataBean;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 预存款适配器
 */
public class DepositAdapter extends BaseAdapter<DepositAdapter.DepositHolder, DataBean> {

    public DepositAdapter(Context context) {
        super(context);
    }

    @Override
    public void onBindViewHolder(DepositAdapter.DepositHolder holder, int position) {
        if(holder.getItemViewType() == TYPE_ITEM){
            final DataBean order = mData.get(position);
            if(order == null) {
                return;
            }
        }
    }

    @Override
    public int provideItemLayoutId() {
        return R.layout.ui_item_deposit;
    }

    @Override
    public DepositHolder createVH(View view) {
        return new DepositHolder(view);
    }

    class DepositHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Nullable
        @Bind(R.id.tv_user)
        TextView tv_user;
        @Nullable
        @Bind(R.id.tv_state)
        TextView tv_state;
        @Nullable
        @Bind(R.id.tv_address)
        TextView tv_address;
        @Nullable
        @Bind(R.id.tv_phone)
        TextView tv_phone;
        @Nullable
        @Bind(R.id.tv_name)
        TextView tv_name;
        @Nullable
        @Bind(R.id.tv_date)
        TextView tv_date;

        OrderHolder(View view) {
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