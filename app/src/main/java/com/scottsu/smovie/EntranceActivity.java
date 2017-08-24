package com.scottsu.smovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.scottsu.smovie.data.source.ComingSoonResponseEntity;
import com.scottsu.smovie.data.source.HotInTheatersResponseEntity;
import com.scottsu.smovie.data.source.MovieDetailResponseEntity;
import com.scottsu.smovie.data.source.Top250ResponseEntity;
import com.scottsu.smovie.data.source.remote.DoubanMovieService;
import com.scottsu.smovie.data.source.remote.RetrofitClient;

import org.w3c.dom.Text;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class EntranceActivity extends AppCompatActivity
{

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        mTextView = (TextView) findViewById(R.id.tv);

        requestTop250();
        requestHotInTheaters();
        requestComingSoon();
        requestSearch();
        requestDetail();
    }

    private void requestTop250()
    {
        RetrofitClient.getInstance().createService(DoubanMovieService.class)
                .requestTop250(0, 2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Top250ResponseEntity>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {

                    }

                    @Override
                    public void onNext(Top250ResponseEntity value)
                    {
                        mTextView.append( "\n" +"\n" +"===>Top250" + "\n" + value.getSubjects().toString());
                    }

                    @Override
                    public void onError(Throwable e)
                    {

                    }

                    @Override
                    public void onComplete()
                    {

                    }
                });
    }

    private void requestHotInTheaters()
    {
        RetrofitClient.getInstance().createService(DoubanMovieService.class)
                .requestHotInTheaters(0, 2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotInTheatersResponseEntity>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {

                    }

                    @Override
                    public void onNext(HotInTheatersResponseEntity value)
                    {
                        mTextView.append("\n" +"\n" + "===>HotInTheaters" + "\n" + value.getSubjects().toString());
                    }

                    @Override
                    public void onError(Throwable e)
                    {

                    }

                    @Override
                    public void onComplete()
                    {

                    }
                });
    }

    private void requestComingSoon(){
        RetrofitClient.getInstance().createService(DoubanMovieService.class)
                .requestComingSoon(0, 2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ComingSoonResponseEntity>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {

                    }

                    @Override
                    public void onNext(ComingSoonResponseEntity value)
                    {
                        mTextView.append("\n" +"\n" + "===>ComingSoon" + "\n" + value.getSubjects().toString());
                    }

                    @Override
                    public void onError(Throwable e)
                    {

                    }

                    @Override
                    public void onComplete()
                    {

                    }
                });
    }


    private void requestSearch(){

            RetrofitClient.getInstance().createService(DoubanMovieService.class)
                    .requestSearch("碟中谍",0, 2)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ComingSoonResponseEntity>()
                    {
                        @Override
                        public void onSubscribe(Disposable d)
                        {

                        }

                        @Override
                        public void onNext(ComingSoonResponseEntity value)
                        {
                            mTextView.append("\n" +"\n" + "===>Search" + "\n" + value.getSubjects().toString());
                        }

                        @Override
                        public void onError(Throwable e)
                        {

                        }

                        @Override
                        public void onComplete()
                        {

                        }
                    });
    }


    private void requestDetail(){
        RetrofitClient.getInstance().createService(DoubanMovieService.class)
                .requestDetail("1292720")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieDetailResponseEntity>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {

                    }

                    @Override
                    public void onNext(MovieDetailResponseEntity value)
                    {
                        mTextView.append("\n" +"\n" + "===>Detail" + "\n" + value.toString());
                    }

                    @Override
                    public void onError(Throwable e)
                    {

                    }

                    @Override
                    public void onComplete()
                    {

                    }
                });
    }
}
