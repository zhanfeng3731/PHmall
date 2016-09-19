package com.zykj.phmall.base;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseAdapter.OnItemClickListener;
import com.zykj.phmall.presenter.ListPresenter;
import com.zykj.phmall.view.ArrayView;

import java.util.List;

import butterknife.Bind;

/**
 * Created by csh
 * Created date 2016/8/27.
 * Description 列表fragment
 */
public abstract class RecycleViewFragment<P extends ListPresenter, A extends BaseAdapter, M> extends ToolBarFragment<P> implements OnItemClickListener,ArrayView<M> {

    @Bind(R.id.recycle_view)
    public RecyclerView recyclerView;
    public A adapter;
    public RecyclerView.LayoutManager layoutManager;

    @Override
    protected void initAllMembersView(View view) {
        super.initAllMembersView(view);
        this.layoutManager = provideLayoutManager();
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        this.adapter = provideAdapter();
        recyclerView.setAdapter(adapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter.setOnItemClickListener(this);
    }

    /**
     * @return 提供LayoutManager
     */
    protected abstract RecyclerView.LayoutManager provideLayoutManager();

    /**
     * @return 提供Adapter
     */
    protected abstract A provideAdapter();

    @Override
    public void showProgress() {}

    @Override
    public void hideProgress() {}

    @Override
    public void loadData() {
        presenter.getList(rootView, 1, 0);
    }

    @Override
    public void addNews(List<M> data, int page) {
        adapter.addDatas(data, page);
    }
}