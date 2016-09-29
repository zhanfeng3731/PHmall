package com.zykj.phmall.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseAdapter;
import com.zykj.phmall.beans.AddressBean;
import com.zykj.phmall.utils.TextUtil;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by 徐学坤 on 2016/9/27.
 */
public class AddressAdapter extends BaseAdapter<AddressAdapter.AddressHolder, AddressBean> {
    public AddressAdapter(Context context) {
        super(context);
    }

    @Override
    public int provideItemLayoutId() {
        return R.layout.ui_item_myaddress;
    }

    @Override
    public AddressHolder createVH(View view) {
        return new AddressHolder(view);
    }

    @Override
    public void onBindViewHolder(AddressHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_ITEM) {
            final AddressBean asb = mData.get(position);
            if (asb == null) {
                return;
            }
            TextUtil.setText(holder.tv_true_name, asb.true_name);
            Log.e("TAG", asb.true_name + "");
            TextUtil.setText(holder.tv_mob_phone, asb.mob_phone);
            TextUtil.setText(holder.tv_area_info, asb.area_info);
            Log.e("TAG", asb.area_info + "");
        }
    }

    class AddressHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Nullable
        @Bind(R.id.tv_true_name)
        TextView tv_true_name;
        @Nullable
        @Bind(R.id.tv_mob_phone)
        TextView tv_mob_phone;
        @Nullable
        @Bind(R.id.tv_area_info)
        TextView tv_area_info;

        AddressHolder(View view) {
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
