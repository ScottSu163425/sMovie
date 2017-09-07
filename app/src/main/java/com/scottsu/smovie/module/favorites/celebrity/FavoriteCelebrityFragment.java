package com.scottsu.smovie.module.favorites.celebrity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.scottsu.slist.library.adapter.SListAdapter;
import com.scottsu.slist.library.interfaces.ListItemCallback;
import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseListFragment;
import com.scottsu.smovie.module.celebrity.Celebrity;
import com.scottsu.smovie.module.web.CommonWebActivity;
import com.scottsu.utils.ActivityLauncher;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.favorites.celebrity
 * description:
 * author: Su
 * date: 2017/9/7 9:52
 */

public class FavoriteCelebrityFragment
        extends BaseListFragment<Celebrity, FavoriteCelebrityContract.View, FavoriteCelebrityContract.Presenter>
        implements FavoriteCelebrityContract.View {

    private FavoriteCelebrityListAdapter mListAdapter;


    public static FavoriteCelebrityFragment newInstance() {
        FavoriteCelebrityFragment fragment = new FavoriteCelebrityFragment();
        return fragment;
    }

    @NonNull
    @Override
    protected SListAdapter<Celebrity> provideListAdapter() {
        if (mListAdapter == null) {
            mListAdapter = new FavoriteCelebrityListAdapter(getContext());
            mListAdapter.setItemCallback(new ListItemCallback<Celebrity>() {
                @Override
                public void onListItemClick(View itemView, Celebrity entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames) {
                    launchCelebrityDetail(entity);
                }

                @Override
                public void onListItemLongClick(View itemView, Celebrity entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames) {

                }
            });

            mListAdapter.setCallback(new FavoriteCelebrityListAdapter.Callback() {
                @Override
                public void onMoreClick(View view, Celebrity entity, int position) {
                    popMenu(view, entity, position);
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

    }

    @Override
    protected void onClickError(View view) {

    }

    @Override
    protected void onRefresh() {

    }

    @Override
    protected void onLoadMore(boolean hasNextPage) {

    }

    @Override
    protected void onListFragmentCreated() {
        getPresenter().subscribe(this);
        getPresenter().requestListData(0, 0, true, false);
    }

    @Override
    protected FavoriteCelebrityContract.Presenter providePresenter() {
        return new FavoriteCelebrityPresenter();
    }

    @Override
    protected boolean enableSwipeRefresh() {
        return false;
    }

    @Override
    protected boolean enableLoadMore() {
        return false;
    }

    @Override
    protected int getEmptyLayout() {
        return R.layout.layout_empty_favorites;
    }

    @Override
    public void onMovieRemoved(Celebrity celebrity, int position) {
        mListAdapter.removeData(position);

        if (mListAdapter.isEmpty()) {
            showEmpty();
        }
    }

    private void popMenu(View view, final Celebrity entity, final int position) {
        android.widget.PopupMenu popupMenu = new android.widget.PopupMenu(getActivity(), view);

        Menu menu = popupMenu.getMenu();
        menu.add(1, 1, 1, getString(R.string.remove));
        popupMenu.setOnMenuItemClickListener(new android.widget.PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == 1) {
                    getPresenter().removeMovie(entity, position);
                }
                return true;
            }
        });
        popupMenu.show();
    }

    private void launchCelebrityDetail(Celebrity entity) {
        Intent intent = new Intent(getActivity(), CommonWebActivity.class);
        intent.putExtra(CommonWebActivity.KEY_EXTRA_URL, entity.getUrl());
        ActivityLauncher.launchWithTransition(getActivity(), intent);
    }
}
