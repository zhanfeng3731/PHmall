package com.zykj.phmall.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yancy.imageselector.ImageLoader;
import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseAdapter;
import com.zykj.phmall.beans.DataBean;
import com.zykj.phmall.network.Const;
import com.zykj.phmall.utils.TextUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by csh
 * Created date 2016/9/14.
 * Description 选择适配器
 */
public class CateAdapter extends BaseAdapter<CateAdapter.CateHolder, DataBean> implements ImageLoader {

    private int id = -1;

    public int getId() {
        return id;
    }

    public void setId(int position) {
        this.id = position;
        notifyDataSetChanged();
    }

    public CateAdapter(Context context) {
        super(context);
    }

    public CateAdapter(Context context, boolean flag) {
        super(context);
        setShowFooter(flag);
    }

    @Override
    public void onBindViewHolder(CateAdapter.CateHolder holder, int position) {
        if(holder.getItemViewType() == TYPE_ITEM){
            final DataBean user = mData.get(position);
            if(user == null) {
                return;
            }
//            if(holder.iv_check != null)
//                holder.iv_check.setSelected(position == this.id);
//            TextUtil.setText(holder.tv_name, user.RealName+user.Id);
//            if(holder.iv_avatar != null)
//                Glide.with(context).load(Const.getUrl(user.ImagePath))
//                        .fitCenter().crossFade()
//                        .transform(new GlideCircleTransform(context))
//                        .placeholder(R.mipmap.ico_avatar)
//                        .into(holder.iv_avatar);
        }
    }

    @Override
    public int provideItemLayoutId() {
        return R.layout.ui_item_classify;
    }

    @Override
    public CateHolder createVH(View view) {
        return new CateHolder(view);
    }

    class CateHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Nullable
        @Bind(R.id.iv_avatar)
        ImageView iv_avatar;
        @Nullable
        @Bind(R.id.tv_name)
        TextView tv_name;

        CateHolder(View view) {
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

    @Override
    public void displayImage(Context context, String path, ImageView imageView) {
        Glide.with(context)
                .load(path)
                .placeholder(com.yancy.imageselector.R.mipmap.imageselector_photo)
                .centerCrop()
                .into(imageView);
    }
}