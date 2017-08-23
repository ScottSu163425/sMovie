package com.scottsu.smovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.scottsu.smovie.data.source.Top250ResponseEntity;
import com.scottsu.smovie.data.source.remote.DoubanMovieService;
import com.scottsu.smovie.data.source.remote.RetrofitClient;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class EntranceActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        RetrofitClient.getInstance().createService(DoubanMovieService.class)
                .requestTop250(0, 1)
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
                        Log.e("===>",value.getSubjects().get(0).toString());
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
