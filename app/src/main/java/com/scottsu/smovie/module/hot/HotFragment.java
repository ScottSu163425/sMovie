package com.scottsu.smovie.module.hot;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.scottsu.slist.library.adapter.SListAdapter;
import com.scottsu.slist.library.interfaces.ListItemCallback;
import com.scottsu.smovie.base.BaseListFragment;
import com.scottsu.smovie.common.events.ListDraggingEvent;
import com.scottsu.smovie.common.events.ListReleasedEvent;
import com.scottsu.smovie.common.events.ScrollToTopEvent;
import com.scottsu.smovie.data.source.MovieSubject;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.hot
 * description:
 * author: Su
 * date: 2017/9/1 8:16
 */

public class HotFragment extends BaseListFragment<MovieSubject, HotContract.View, HotContract.Presenter>
        implements HotContract.View {

    private static final int MIN_SMOOTH_SCROLL_ITEM = 45;
    private HotListAdapter mListAdapter;


    public static HotFragment newInstance() {
        HotFragment fragment = new HotFragment();
        return fragment;
    }

    @NonNull
    @Override
    protected SListAdapter<MovieSubject> provideListAdapter() {
        if (mListAdapter == null) {
            mListAdapter = new HotListAdapter(getContext());
            mListAdapter.setShowEndingFooter(true);
            mListAdapter.setItemCallback(new ListItemCallback<MovieSubject>() {
                @Override
                public void onListItemClick(View itemView, MovieSubject entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames) {
                    Toast.makeText(getContext(), "onListItemClick " + entity.getTitle(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onListItemLongClick(View itemView, MovieSubject entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames) {
                    Toast.makeText(getContext(), "onListItemLongClick " + entity.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        return mListAdapter;
    }

    @Nullable
    @Override
    protected RecyclerView.LayoutManager provideListLayoutManager() {
        return null;
    }

    @Override
    protected void onClickEmpty(View view) {
        requestListData(true, false);
    }

    @Override
    protected void onClickError(View view) {
        requestListData(true, false);
    }

    @Override
    protected void onRefresh() {
        requestListData(false, false);
    }

    @Override
    protected void onLoadMore(boolean hasNextPage) {
        if (hasNextPage) {
            requestListData(false, true);
        }
    }

    @Override
    protected void onListFragmentCreated() {
        getPresenter().subscribe(this);

        requestListData(true, false);
    }

    @Override
    protected HotContract.Presenter providePresenter() {
        return new HotPresenter();
    }

    @Override
    protected void onListDragging() {
        super.onListDragging();

        EventBus.getDefault().post(new ListDraggingEvent());
    }

    @Override
    protected int getDefaultStateBackgroundColor() {
        return Color.TRANSPARENT;
    }

    @Override
    protected void onListReleased() {
        super.onListReleased();

        EventBus.getDefault().post(new ListReleasedEvent());
    }

    @Override
    protected boolean subscribeEvents() {
        return true;
    }

    @Subscribe
    public void onScrollToTop(ScrollToTopEvent event) {
        if (isHidden()) {
            return;
        }

        scrollToTop(getLastVisibleItemPosition() < MIN_SMOOTH_SCROLL_ITEM);
    }

    private void requestListData(boolean showLoading, boolean loadMore) {
        getPresenter().requestListData(loadMore ? getPagingRequestManager().getCurrentIndex()
                        : getPagingRequestManager().getFirstIndex(),
                getPagingRequestManager().getPageSize(),
                showLoading, loadMore);
    }

}

