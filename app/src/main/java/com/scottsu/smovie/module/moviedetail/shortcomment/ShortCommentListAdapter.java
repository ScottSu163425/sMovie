package com.scottsu.smovie.module.moviedetail.shortcomment;

import android.content.Context;
import android.view.ViewGroup;

import com.scottsu.slist.library.adapter.SListAdapter;
import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.smovie.R;

import java.util.List;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.moviedetail.shortcomment
 * description:
 * author: Su
 * date: 2017/9/8 16:41
 */

public class ShortCommentListAdapter extends SListAdapter<ShortComment> {
    public ShortCommentListAdapter(Context context) {
        super(context);
    }

    public ShortCommentListAdapter(Context context, List<ShortComment> dataList) {
        super(context, dataList);
    }

    @Override
    protected boolean autoRegisterItemCallback() {
        return true;
    }

    @Override
    protected SListViewHolder<ShortComment> onCreateVH(ViewGroup parent, int viewType) {
        return new ShortCommentItemViewHolder(parent, R.layout.item_short_comment);
    }

    @Override
    protected void onBindVH(SListViewHolder<ShortComment> holder, ShortComment entity, int position) {
        holder.bindData(getContext(), entity, position);
    }
}
