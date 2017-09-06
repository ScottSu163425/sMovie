package com.scottsu.smovie.module.search;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.scottsu.slist.library.adapter.SListAdapter;
import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.smovie.R;
import com.scottsu.smovie.data.enity.MovieSubject;

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
        return false;
    }

    @Override
    protected SListViewHolder<MovieSubject> onCreateVH(ViewGroup parent, int viewType) {
        return new SearchListItemViewHolder(parent, R.layout.item_search);
    }

    @Override
    protected void onBindVH(SListViewHolder<MovieSubject> holder, final MovieSubject entity, final int position) {
        holder.bindData(getContext(), entity, position);

        final SearchListItemViewHolder viewHolder = (SearchListItemViewHolder) holder;
        final ImageView sharedElement = viewHolder.getCoverImageView();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getItemCallback().onListItemClick(view, entity, position,
                        new View[]{sharedElement},
                        new String[]{ViewCompat.getTransitionName(sharedElement)});
            }
        });
    }

}
