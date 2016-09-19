package com.zykj.phmall.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseAdapter;
import com.zykj.phmall.beans.DataBean;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by csh
 * Created date 2016/9/18.
 * Description
 */
public class MessageAdapter extends BaseAdapter<MessageAdapter.MessageHolder, DataBean>{

    public MessageAdapter(Context context) {
        super(context);
    }

    public MessageAdapter(Context context, boolean flag) {
        super(context);
        setShowFooter(flag);
    }

    @Override
    public void onBindViewHolder(MessageAdapter.MessageHolder holder, int position) {
        if(holder.getItemViewType() == TYPE_ITEM){
            final DataBean user = mData.get(position);
            if(user == null) {
                return;
            }
        }
    }

    @Override
    public int provideItemLayoutId() {
        return R.layout.ui_item_message;
    }

    @Override
    public MessageHolder createVH(View view) {
        return new MessageHolder(view);
    }

    class MessageHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Nullable
        @Bind(R.id.iv_avatar)
        ImageView iv_avatar;
        @Nullable
        @Bind(R.id.tv_name)
        TextView tv_name;

        MessageHolder(View view) {
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