package com.zykj.phmall.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseAdapter;
import com.zykj.phmall.beans.MessageBean;
import com.zykj.phmall.utils.TextUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by csh
 * Created date 2016/9/18.
 * Description 消息适配器
 */
public class MessageAdapter extends BaseAdapter<MessageAdapter.MessageHolder, MessageBean>{

    public MessageAdapter(Context context) {
        super(context);
    }

    @Override
    public void onBindViewHolder(MessageAdapter.MessageHolder holder, int position) {
        if(holder.getItemViewType() == TYPE_ITEM){
            final MessageBean msg = mData.get(position);
            if(msg == null) {
                return;
            }
            TextUtil.setText(holder.tv_title, "member_fund".equals(msg.url_type)?"余额":"订单");
            TextUtil.setText(holder.tv_content, msg.message_body);
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
        @Bind(R.id.tv_title)
        TextView tv_title;
        @Nullable
        @Bind(R.id.tv_content)
        TextView tv_content;

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