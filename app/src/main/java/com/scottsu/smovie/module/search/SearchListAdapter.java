package com.scottsu.smovie.module.search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.scottsu.slist.library.adapter.SListAdapter;
import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.smovie.R;
import com.scottsu.smovie.data.enity.MovieSubject;
import com.scottsu.smovie.module.hot.HotItemViewHolder;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.List;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.search
 * description:
 * author: Su
 * date: 2017/9/1 9:53
 */

public class SearchListAdapter extends SListAdapter<MovieSubject> {
    public SearchListAdapter(Context context) {
        super(context);
    }

    public SearchListAdapter(Context context, List<MovieSubject> dataList) {
        super(context, dataList);
    }

    @Override
    protected boolean autoRegisterItemCallback() {
        return true;
    }

    @Override
    protected SListViewHolder<MovieSubject> onCreateVH(ViewGroup parent, int viewType) {
        return new HotItemViewHolder(parent, R.layout.item_hot);
    }

    @Override
    protected void onBindVH(SListViewHolder<MovieSubject> holder, MovieSubject entity, int position) {
        holder.bindData(getContext(), entity, position);
    }

}
