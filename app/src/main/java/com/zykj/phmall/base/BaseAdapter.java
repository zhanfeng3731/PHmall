package com.zykj.phmall.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zykj.phmall.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by csh
 * Created date 2016/8/27.
 * Description 适配器
 */
public abstract class BaseAdapter<VH extends RecyclerView.ViewHolder, M> extends RecyclerView.Adapter<VH>{

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;
    public static final int TYPE_FOOTER = -1;

    public Context context;
    private View header;

    public OnItemClickListener mOnItemClickListener;
    /**
     * 数据
     */
    public List<M> mData = new ArrayList<>();
    private boolean mShowFooter = true;
    private LayoutInflater mInflater;

    public BaseAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    public BaseAdapter(Context context, View header) {
        this.context = context;
        this.header = header;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        // 最后一个item设置为footerView
        if (header != null) {
            if (position == 0) {
                return TYPE_HEADER;
            }
        }
        if(mShowFooter) {
            if (position + 1 == getItemCount()) {
                return TYPE_FOOTER;
            }
        }
        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        int begin = header!=null?1:0;
        int end = mShowFooter?1:0;
        return begin + mData.size() + end;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER) {
            return createVH(header);
        } else if(viewType == TYPE_ITEM) {
            View v = mInflater.inflate(provideItemLayoutId(), parent, false);
            return createVH(v);
        } else {
            View view = mInflater.inflate(R.layout.ui_view_footer, parent, false);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            return createVH(view);
        }
    }

    /**
     * @return ItemView的LayoutId
     */
    public abstract int provideItemLayoutId();

    /**
     * @param view item视图
     * @return 创建ViewHolder
     */
    public abstract VH createVH(View view);

    public void setShowFooter(boolean showFooter) {
        this.mShowFooter = showFooter;
    }

    public boolean isShowFooter() {
        return this.mShowFooter;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    /**
     * 加载数据
     * @param data 数据
     */
    public void addDatas(List<M> data, int page) {
        if(page == 1)
            this.mData.clear();
        this.mData.addAll(data);
        this.notifyDataSetChanged();
    }
}