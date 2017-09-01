package com.scottsu.smovie.data.source.remote;

import com.scottsu.smovie.data.enity.ComingSoonResponseEntity;
import com.scottsu.smovie.data.enity.HotResponseEntity;
import com.scottsu.smovie.data.enity.MovieDetailResponseEntity;
import com.scottsu.smovie.data.enity.SearchResponseEntity;
import com.scottsu.smovie.data.enity.Top250ResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.data.source.remote
 * 描述:
 * 作者: Su
 * 日期: 2017/8/23 16:24
 **/
public interface ApiService {

    @FormUrlEncoded
    @POST("in_theaters")
    Observable<HotResponseEntity> requestHot(@Field("apikey") String apikey,
                                             @Field("start") int start,
                                             @Field("count") int count);

    @FormUrlEncoded
    @POST("top250")
    Observable<Top250ResponseEntity> requestTop250(@Field("apikey") String apikey,
                                                   @Field("start") int start, @Field("count") int count);

    @FormUrlEncoded
    @POST("coming_soon")
    Observable<ComingSoonResponseEntity> requestComingSoon(@Field("apikey") String apikey,
                                                           @Field("start") int start, @Field("count") int count);

    @FormUrlEncoded
    @POST("search")
    Observable<SearchResponseEntity> requestSearch(@Field("apikey") String apikey,
                                                   @Field("q") String keyword, @Field("start") int start,
                                                   @Field("count") int count);

    @FormUrlEncoded
    @POST("subject/{id}")
    Observable<MovieDetailResponseEntity> requestDetail(@Field("apikey") String apikey,
                                                        @Path("id") String movieId);


}
