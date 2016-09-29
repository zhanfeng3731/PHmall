package com.zykj.phmall.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseAdapter;
import com.zykj.phmall.beans.FundBean;
import com.zykj.phmall.utils.DateUtil;
import com.zykj.phmall.utils.TextUtil;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 预存款适配器
 */
public class DepositAdapter extends BaseAdapter<DepositAdapter.DepositHolder, FundBean> {

    private int type = R.id.tv_left;

    public DepositAdapter(Context context, View headView) {
        super(context, headView);
    }

    public void setType(int type){
        this.type = type;
    }

    @Override
    public void onBindViewHolder(DepositAdapter.DepositHolder holder, int position) {
        if(holder.getItemViewType() == TYPE_ITEM){
            final FundBean prede = mData.get(position-1);//减去headview的position
            if(prede == null) {
                return;
            }
            int i = type==R.id.tv_left?0:type==R.id.tv_middle?1:2;
            String name = i==0?prede.lg_desc:i==1?prede.pdr_payment_name:prede.pdc_bank_no;
            String amount = i==0?prede.lg_av_amount:i==1?prede.pdr_amount:prede.pdc_amount;
            String time = i==0?prede.lg_add_time:i==1?prede.pdr_add_time:prede.pdc_add_time;
            TextUtil.setText(holder.tv_title, name);
            String red = "<font color=#DB4453>+"+amount+"</font>";
            String green = "<font color=#5EAD20>"+amount+"</font>";
            if(holder.tv_money != null)
                holder.tv_money.setText(Html.fromHtml(Float.valueOf(amount)<0?green:red));
            TextUtil.setText(holder.tv_date, DateUtil.longToString(Long.valueOf(time), "yyyy-MM-dd"));
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
        @Bind(R.id.tv_title)
        TextView tv_title;
        @Nullable
        @Bind(R.id.tv_money)
        TextView tv_money;
        @Nullable
        @Bind(R.id.tv_date)
        TextView tv_date;

        DepositHolder(View view) {
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