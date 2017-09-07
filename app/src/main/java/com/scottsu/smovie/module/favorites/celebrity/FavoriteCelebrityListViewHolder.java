package com.scottsu.smovie.module.favorites.celebrity;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.smovie.R;
import com.scottsu.smovie.common.ImageLoader;
import com.scottsu.smovie.module.celebrity.Celebrity;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.favorites.celebrity
 * description:
 * author: Su
 * date: 2017/9/7 9:43
 */

public class FavoriteCelebrityListViewHolder extends SListViewHolder<Celebrity> {
    private ImageView mAvatarImageView;
    private TextView mNameTextView;
    private View mMoreView;


    public FavoriteCelebrityListViewHolder(View itemView) {
        super(itemView);

        init();
    }

    public FavoriteCelebrityListViewHolder(ViewGroup parent, @LayoutRes int layoutRes) {
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
        ImageLoader.load(context, entity.getAvatar(), mAvatarImageView);
        mNameTextView.setText(entity.getName());
    }

    public View getMoreView() {
        return mMoreView;
    }
}
