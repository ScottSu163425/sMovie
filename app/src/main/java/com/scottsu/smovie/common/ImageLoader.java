package com.scottsu.smovie.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.scottsu.smovie.R;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.common
 * 描述:
 * 作者: Su
 * 日期: 2017/8/30 9:34
 **/
public class ImageLoader {
    private static final int PLACE_HOLDER_DEFAULT = R.color.md_grey_300;

    public interface Callback {
        void onResourceReady(Drawable resource);
    }

    public static void load(Context context, String url, ImageView target) {
        load(context, url, target, PLACE_HOLDER_DEFAULT, PLACE_HOLDER_DEFAULT, true, true, null);
    }

    public static void load(Context context, String url, ImageView target, boolean centerCrop) {
        load(context, url, target, PLACE_HOLDER_DEFAULT, PLACE_HOLDER_DEFAULT, centerCrop, true, null);
    }


    public static void load(Context context, String url, ImageView target, boolean centerCrop, boolean animation) {
        load(context, url, target, PLACE_HOLDER_DEFAULT, PLACE_HOLDER_DEFAULT, centerCrop, animation, null);
    }

    public static void load(Context context, String url, ImageView target, Callback callback) {
        load(context, url, target, PLACE_HOLDER_DEFAULT, PLACE_HOLDER_DEFAULT, true, true, callback);
    }

    public static void load(Context context, String url, final ImageView target, int placeHolder, int errorHolder, boolean centerCrop, boolean animation, @Nullable final Callback callback) {
        RequestOptions options = new RequestOptions()
                .placeholder(placeHolder)
                .error(errorHolder);

        if (!animation) {
            options.dontAnimate();
        }

        if (centerCrop) {
            options.centerCrop();
        }

        RequestBuilder<Drawable> requestBuilder = Glide.with(context)
                .load(url)
                .apply(options);

        if (animation) {
            requestBuilder.transition(new DrawableTransitionOptions().crossFade());
        }

        if (callback != null) {
            requestBuilder.into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    target.setImageDrawable(resource);

                    callback.onResourceReady(resource);
                }
            });
        } else {
            requestBuilder.into(target);
        }
    }


}
