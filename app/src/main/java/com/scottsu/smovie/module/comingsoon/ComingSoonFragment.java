package com.scottsu.smovie.module.comingsoon;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.scottsu.slist.library.adapter.SListAdapter;
import com.scottsu.slist.library.interfaces.ListItemCallback;
import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseListFragment;
import com.scottsu.smovie.common.events.ListDraggingEvent;
import com.scottsu.smovie.common.events.ListReleasedEvent;
import com.scottsu.smovie.common.events.ScrollToTopEvent;
import com.scottsu.smovie.data.enity.MovieSubject;
import com.scottsu.smovie.data.source.local.FavoriteMovieRepository;
import com.scottsu.smovie.module.moviedetail.MovieDetailActivity;
import com.scottsu.utils.ActivityLauncher;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.comingsoon
 * description:
 * author: Su
 * date: 2017/9/1 9:26
 */

public class ComingSoonFragment extends BaseListFragment<MovieSubject, ComingSoonContract.View, ComingSoonContract.Presenter>
        implements ComingSoonContract.View {

    private static final int MIN_SMOOTH_SCROLL_ITEM = 40;
    private ComingSoonListAdapter mListAdapter;


    public static ComingSoonFragment newInstance() {
        ComingSoonFragment fragment = new ComingSoonFragment();
        return fragment;
    }

    @NonNull
    @Override
    protected SListAdapter<MovieSubject> provideListAdapter() {
        if (mListAdapter == null) {
            mListAdapter = new ComingSoonListAdapter(getContext());
            mListAdapter.setShowEndingFooter(true);
            mListAdapter.setItemCallback(new ListItemCallback<MovieSubject>() {
                @Override
                public void onListItemClick(View itemView, MovieSubject entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames) {
                    launchMovieDetail(entity, sharedElements, transitionNames);
                    new FavoriteMovieRepository().save(entity);                }

                @Override
                public void onListItemLongClick(View itemView, MovieSubject entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames) {
                }
            });
        }
        return mListAdapter;
    }

    @Nullable
    @Override
    protected RecyclerView.LayoutManager provideListLayoutManager() {
        return new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
    }

    @Override
    protected int getListPadding() {
        return getResources().getDimensionPixelSize(R.dimen.padding_xs);
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
    protected ComingSoonContract.Presenter providePresenter() {
        return new ComingSoonPresenter();
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

    private void launchMovieDetail(MovieSubject entity, View[] sharedElements, String[] transitionNames) {
        Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
        intent.putExtra(MovieDetailActivity.KEY_EXTRA_MOVIE_SUBJECT, entity);

        ActivityLauncher.launchWithSharedElement(getActivity(), intent, sharedElements[0], transitionNames[0]);
    }

}

