package com.zykj.phmall.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseAdapter;
import com.zykj.phmall.beans.VoucherBean;
import com.zykj.phmall.utils.TextUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 徐学坤 on 2016/9/24.
 */
public class VoucherAdapter extends BaseAdapter<VoucherAdapter.VoucherHolder, VoucherBean> {

    public VoucherAdapter(Context context) {
        super(context);
    }

    @Override
    public int provideItemLayoutId() {
        Log.e("TAG", "++++++++++++");
        return R.layout.ui_item_cardview;
    }

    @Override
    public VoucherHolder createVH(View view) {
        Log.e("TAG", "----------");
        return new VoucherHolder(view);
    }

    @Override
    public void onBindViewHolder(VoucherHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_ITEM) {
            final VoucherBean vcb = mData.get(position);
            if (vcb == null) {
                return;
            }
            TextUtil.setText(holder.tv_shopname, vcb.voucher_title);
            TextUtil.setText(holder.usedate, "使用期限" + vcb.voucher_end_date_text);
            TextUtil.setText(holder.tv_djqmoney, "￥" + vcb.voucher_price);
        }

    }

    class VoucherHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Nullable
        @Bind(R.id.tv_shopname)
        TextView tv_shopname;
        @Nullable
        @Bind(R.id.usedate)
        TextView usedate;
        @Nullable
        @Bind(R.id.tv_djqmoney)
        TextView tv_djqmoney;

        VoucherHolder(View view) {
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
