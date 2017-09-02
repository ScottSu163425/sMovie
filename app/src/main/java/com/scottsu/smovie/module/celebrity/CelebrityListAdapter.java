package com.scottsu.smovie.module.celebrity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.scottsu.slist.library.adapter.SListAdapter;
import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.slist.library.interfaces.ListItemCallback;
import com.scottsu.smovie.R;

import java.util.List;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.celebrity
 * description:
 * author: Su
 * date: 2017/9/2 21:10
 */

public class CelebrityListAdapter extends SListAdapter<Celebrity> {
    private Callback mCallback;


    public CelebrityListAdapter(Context context) {
        super(context);
    }

    public CelebrityListAdapter(Context context, List<Celebrity> dataList) {
        super(context, dataList);
    }

    @Override
    protected boolean autoRegisterItemCallback() {
        return false;
    }

    @Override
    protected SListViewHolder<Celebrity> onCreateVH(ViewGroup parent, int viewType) {
        return new CelebrityItemViewHolder(parent, R.layout.item_celebrity);
    }

    @Override
    protected void onBindVH(SListViewHolder<Celebrity> holder, final Celebrity entity, final int position) {
        holder.bindData(getContext(), entity, position);

        CelebrityItemViewHolder viewHolder = (CelebrityItemViewHolder) holder;
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getItemCallback().onListItemClick(view, entity, position, null, null);
            }
        });

        viewHolder.getMoreView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCallback().onMoreClick(view, entity, position);
            }
        });
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    private Callback getCallback() {
        if (mCallback == null) {
            mCallback = new Callback() {
                @Override
                public void onMoreClick(View view, Celebrity entity, int position) {

                }
            };
        }
        return mCallback;
    }

    public interface Callback {
        void onMoreClick(View view, Celebrity entity, int position);
    }

}
