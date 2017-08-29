package com.scottsu.smovie.module.top250;


import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scottsu.library.mvp.util.PagingRequestManager;
import com.scottsu.slist.library.interfaces.ListItemCallback;
import com.scottsu.slist.library.interfaces.LoadMoreListener;
import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseFragment;
import com.scottsu.smovie.data.source.MovieSubject;
import com.scottsu.stateslayout.StatesLayout;

import java.util.List;

/**
 * package: com.scottsu.smovie.module.top250
 * description:
 * author: Su
 * date: 2017/8/27 17:10
 */

public class Top250Fragment extends BaseFragment<Top250Contract.View, Top250Contract.Presenter>
        implements Top250Contract.View
{

    private StatesLayout mStatesLayout;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private Top250ListAdapter mListAdapter;
    private PagingRequestManager mPagingRequestManager;


    public static Top250Fragment newInstance()
    {
        Top250Fragment fragment = new Top250Fragment();
        return fragment;
    }

    @Override
    protected int provideContentLayoutRes()
    {
        return R.layout.fragment_top_250;
    }

    @Override
    protected Top250Contract.Presenter providePresenter()
    {
        return new Top250Presneter(Top250Fragment.this);
    }


    @Override
    protected void onFragmentCreated()
    {
        mStatesLayout = (StatesLayout) findViewById(R.id.states_layout);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mListAdapter = new Top250ListAdapter(getContext());
        mPagingRequestManager = new PagingRequestManager(0, 10);

        mRecyclerView.addOnScrollListener(new LoadMoreListener()
        {
            @Override
            public void onLoadMore()
            {
                getPresenter().onLoadMoreListData();
            }
        });

        mStatesLayout.setCallback(new StatesLayout.StatesLayoutCallback()
        {
            @Override
            public void onEmptyClick(View view)
            {
                getPresenter().onClickEmpty();
            }

            @Override
            public void onErrorClick(View view)
            {
                getPresenter().onClickError();
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                getPresenter().onRefreshListData();
            }
        });

        mListAdapter.setItemCallback(new ListItemCallback<MovieSubject>()
        {
            @Override
            public void onListItemClick(View itemView, MovieSubject entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames)
            {

            }

            @Override
            public void onListItemLongClick(View itemView, MovieSubject entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames)
            {

            }
        });


        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mListAdapter);
    }

    @Override
    public void fillListData(List<MovieSubject> data, boolean append)
    {
        if (append)
        {
            mListAdapter.addDataList(data);
        } else
        {
            mListAdapter.setDataList(data);
        }
    }

    @Override
    public void showNoMoreData()
    {

    }

    @Override
    public int getPageSize()
    {
        return mPagingRequestManager.getPageSize();
    }

    @Override
    public int getCurrentPage()
    {
        return mPagingRequestManager.getCurrentPage();
    }

    @Override
    public boolean hasNextPage()
    {
        return mPagingRequestManager.hasNextPage();
    }

    @Override
    public int turnToFirstPage()
    {
        return mPagingRequestManager.turnToFirstPage();
    }

    @Override
    public int turnToNextPage()
    {
        mListAdapter.setHasMoreData(true);
        return mPagingRequestManager.turnToNextPage();
    }

    @Override
    public int setLastPage()
    {
        mListAdapter.setHasMoreData(false);
        return mPagingRequestManager.setLastPage();
    }

    @Override
    public void showLoading()
    {
        mStatesLayout.showLoading();
    }

    @Override
    public void showEmpty()
    {
        mStatesLayout.showEmpty();
    }

    @Override
    public void showError()
    {
        mStatesLayout.showError();
    }

    @Override
    public void showContent()
    {
        mStatesLayout.showContent();
    }
}
