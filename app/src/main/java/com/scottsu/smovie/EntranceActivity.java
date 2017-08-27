package com.scottsu.smovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.scottsu.smovie.module.main.MainActivity;

public class EntranceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        startActivity(new Intent(this, MainActivity.class));
    }


}
