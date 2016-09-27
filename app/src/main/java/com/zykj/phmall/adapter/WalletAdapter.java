package com.zykj.phmall.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseAdapter;
import com.zykj.phmall.beans.WalletBean;
import com.zykj.phmall.utils.TextUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 徐学坤 on 2016/9/27.
 */
public class WalletAdapter extends BaseAdapter<WalletAdapter.WalletHolder, WalletBean> {

    public WalletAdapter(Context context) {
        super(context);
    }

    @Override
    public int provideItemLayoutId() {
        return R.layout.ui_item_wallet_cardview;
    }

    @Override
    public WalletHolder createVH(View view) {
        return new WalletHolder(view);
    }

    @Override
    public void onBindViewHolder(WalletHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_ITEM) {
            final WalletBean wtb = mData.get(position);
            if (wtb == null) {
                return;
            }
            TextUtil.setText(holder.tv_end_date, wtb.rpacket_end_date_text);
            TextUtil.setText(holder.tv_wallet, wtb.rpacket_title);
            TextUtil.setText(holder.tv_money_count, wtb.rpacket_price);
            TextUtil.setText(holder.tv_used_limit, "满" + wtb.rpacket_limit + "可用");
            TextUtil.setText(holder.tv_limit, "仅限" + wtb.rpacket_owner_name + "账号使用");
        }
    }

    class WalletHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Nullable
        @Bind(R.id.tv_end_date)
        TextView tv_end_date;
        @Nullable
        @Bind(R.id.tv_wallet)
        TextView tv_wallet;
        @Nullable
        @Bind(R.id.tv_used_limit)
        TextView tv_used_limit;
        @Nullable
        @Bind(R.id.tv_money_count)
        TextView tv_money_count;
        @Nullable
        @Bind(R.id.tv_limit)
        TextView tv_limit;

        WalletHolder(View view) {
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