package com.scottsu.smovie.module.moviedetail.shortcomment;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.smovie.R;
import com.scottsu.smovie.common.ImageLoader;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.moviedetail.shortcomment
 * description:
 * author: Su
 * date: 2017/9/8 16:36
 */

public class ShortCommentItemViewHolder extends SListViewHolder<ShortComment> {
    private TextView mNameTextView, mDateTextView, mContentTextView;
    private RatingBar mRatingBar;
    private ImageView mAvatarImageView;


    public ShortCommentItemViewHolder(View itemView) {
        super(itemView);

        init();
    }

    public ShortCommentItemViewHolder(ViewGroup parent, @LayoutRes int layoutRes) {
        super(parent, layoutRes);

        init();
    }

    private void init() {
        mNameTextView = (TextView) findViewById(R.id.tv_name);
        mDateTextView = (TextView) findViewById(R.id.tv_date);
        mContentTextView = (TextView) findViewById(R.id.tv_content);
        mRatingBar = (RatingBar) findViewById(R.id.rating_bar_rating);
        mAvatarImageView = (ImageView) findViewById(R.id.iv_avatar);
    }

    @Override
    public void bindData(Context context, ShortComment entity, int position) {
        mNameTextView.setText(entity.getUserName());
        mDateTextView.setText(entity.getDate());
        mContentTextView.setText(entity.getContent());

        mRatingBar.setProgress((int) entity.getRating());
        ImageLoader.load(context, entity.getAvatar(), mAvatarImageView, true, false);
    }


}
