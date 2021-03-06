package com.scottsu.smovie.module.moviedetail.celebrity;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.smovie.R;
import com.scottsu.smovie.common.ImageLoader;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.Celebrity
 * description:
 * author: Su
 * date: 2017/9/2 21:04
 */

public class CelebrityItemViewHolder extends SListViewHolder<Celebrity> {
    private ImageView mAvatarImageView;
    private TextView mNameTextView;
    private View mMoreView;


    public CelebrityItemViewHolder(View itemView) {
        super(itemView);

        init();
    }

    public CelebrityItemViewHolder(ViewGroup parent, @LayoutRes int layoutRes) {
        super(parent, layoutRes);

        init();
    }

    private void init() {
        mAvatarImageView = (ImageView) findViewById(R.id.iv_avatar);
        mNameTextView = (TextView) findViewById(R.id.tv_name);
        mMoreView = findViewById(R.id.fl_more);
    }

    @Override
    public void bindData(Context context, Celebrity entity, int position) {
        ImageLoader.load(context, entity.getAvatar(), mAvatarImageView, true, false);
        mNameTextView.setText(entity.getName());
    }

    public View getMoreView() {
        return mMoreView;
    }

}
