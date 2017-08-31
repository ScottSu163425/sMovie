package com.scottsu.smovie.base;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.TypedValue;
import android.view.View;

import com.scottsu.library.mvp.presenter.IMvpPresenter;
import com.scottsu.library.mvp.view.IMvpView;
import com.scottsu.slist.library.adapter.SListAdapter;
import com.scottsu.slist.library.interfaces.LoadMoreListener;
import com.scottsu.smovie.R;
import com.scottsu.smovie.common.OnDraggingListener;
import com.scottsu.smovie.common.PagingRequestManager;
import com.scottsu.stateslayout.StatesLayout;

import java.util.List;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.base
 * 描述:
 * 作者: Su
 * 日期: 2017/8/30 10:24
 **/
public abstract class BaseListFragment<E, V extends IMvpView, P extends IMvpPresenter<V>>
        extends BaseFragment<V, P>
        implements BaseListView<E> {
    private static final
    @LayoutRes
    int LAYOUT_RES_NONE = 0x123;

    private StatesLayout mStatesLayout;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private SListAdapter<E> mListAdapter;
    private PagingRequestManager mPagingRequestManager;

    @NonNull
    protected abstract SListAdapter<E> provideListAdapter();

    /**
     * 默认支持竖直方向，若实现水平方向需要调整Fragment容器宽高
     *
     * @return
     */
    @Nullable
    protected abstract RecyclerView.LayoutManager provideListLayoutManager();

    protected abstract void onClickEmpty(View view);

    protected abstract void onClickError(View view);

    protected abstract void onRefresh();

    protected abstract void onLoadMore(boolean hasNextPage);

    protected abstract void onListFragmentCreated();

    @Override
    protected int provideContentLayoutRes() {
        return R.layout.fragment_base_list;
    }

    @Override
    protected void onFragmentCreated() {
        int loadingColor = getDefaultLoadingColor();

        mStatesLayout = (StatesLayout) findViewById(R.id.states_layout);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);

        mListAdapter = provideListAdapter();
        mPagingRequestManager = new PagingRequestManager(0, 0, 10);

        mListAdapter.setDefaultLoadingFooterColor(loadingColor);

        //setup StatesLayout.
        mStatesLayout.setDefaultLoadingWheelColor(loadingColor);
        if (getLoadingLayout() != LAYOUT_RES_NONE) {
            mStatesLayout.setLoadingView(getLoadingLayout());
        }

        if (getEmptyLayout() != LAYOUT_RES_NONE) {
            mStatesLayout.setEmptyView(getEmptyLayout());
        }

        if (getErrorLayout() != LAYOUT_RES_NONE) {
            mStatesLayout.setErrorView(getErrorLayout());
        }

        mStatesLayout.setCallback(new StatesLayout.StatesLayoutCallback() {
            @Override
            public void onEmptyClick(View view) {
                onClickEmpty(view);
            }

            @Override
            public void onErrorClick(View view) {
                onClickError(view);
            }
        });

        //setup SwipeRefreshLayout.
        mSwipeRefreshLayout.setColorSchemeColors(loadingColor);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                if (isLoadingFooter())
//                {
//                    return;
//                }

                mPagingRequestManager.turnToFirstPage();
                BaseListFragment.this.onRefresh();
            }
        });

        //setup RecyclerView.
        RecyclerView.LayoutManager layoutManager = provideListLayoutManager();
        mRecyclerView.setLayoutManager(layoutManager == null ? generateDefaultLayoutManager() : layoutManager);
        mRecyclerView.addOnScrollListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                if (isRefreshing()) {
                    return;
                }

                if (mPagingRequestManager.hasNextPage()) {
                    mListAdapter.showFooter();
                }

                BaseListFragment.this.onLoadMore(mPagingRequestManager.hasNextPage());
            }
        });

        mRecyclerView.addOnScrollListener(new OnDraggingListener() {
            @Override
            public void onDragging() {
                onListDragging();
            }

            @Override
            public void onReleased() {
                onListReleased();
            }
        });

        mRecyclerView.setAdapter(mListAdapter);
        onListFragmentCreated();
    }

    @Override
    public void showLoading() {
        mStatesLayout.showLoading();
    }

    @Override
    public void showEmpty() {
        mStatesLayout.showEmpty();
    }

    @Override
    public void showError() {
        mStatesLayout.showError();
    }

    @Override
    public void showContent() {
        mStatesLayout.showContent();
    }

    @Override
    public void showListData(List<E> data, boolean loadMore, boolean hasNextPage) {
        stopLoading();

        if (loadMore) {
            mListAdapter.addData(data);
        } else {
            mListAdapter.setData(data);
        }

        mListAdapter.setHasMoreData(hasNextPage);

        if (hasNextPage) {
            mPagingRequestManager.turnToNextPage();
        } else {
            mPagingRequestManager.setLastPage();
        }

    }

    /**
     * 加载控件颜色，子类可重写设置
     *
     * @return
     */
    protected int getDefaultLoadingColor() {
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true);
        return typedValue.data;
    }

    protected void onListDragging() {
    }

    protected void onListReleased() {
    }

    protected PagingRequestManager getPagingRequestManager() {
        return mPagingRequestManager;
    }

    protected int getLastVisibleItemPosition() {
        RecyclerView.LayoutManager layoutManager = mRecyclerView.getLayoutManager();
        int lastPosition = 0;

        if (layoutManager instanceof LinearLayoutManager) {
            lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            lastPosition = staggeredGridLayoutManager.findLastVisibleItemPositions(null)[staggeredGridLayoutManager.getSpanCount() - 1];
        }
        return lastPosition;
    }

    protected void scrollToTop(boolean anim) {
        if (anim) {
            mRecyclerView.smoothScrollToPosition(0);
        } else {
            mRecyclerView.scrollToPosition(0);
        }
    }

    protected
    @LayoutRes
    int getLoadingLayout() {
        return LAYOUT_RES_NONE;
    }

    protected
    @LayoutRes
    int getEmptyLayout() {
        return LAYOUT_RES_NONE;
    }

    protected
    @LayoutRes
    int getErrorLayout() {
        return LAYOUT_RES_NONE;
    }

    public RecyclerView getListRecyclerView() {
        return mRecyclerView;
    }

    private RecyclerView.LayoutManager generateDefaultLayoutManager() {
        return new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
    }

    private void stopLoading() {
        stopRefreshing();
        stopLoadingFooter();
    }

    private boolean isRefreshing() {
        return mSwipeRefreshLayout.isRefreshing();
    }

    private void stopRefreshing() {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    private boolean isLoadingFooter() {
        return mListAdapter.isFooterShown();
    }

    private void stopLoadingFooter() {
        mListAdapter.hideFooter();
    }


}
