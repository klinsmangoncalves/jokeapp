package com.udacity.gradle.imageactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class ImageActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA = "joke_content_extra";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent intent = getIntent();

        if(intent != null && intent.hasExtra(JOKE_EXTRA)){
            ImageActivityFragment fragment = (ImageActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
            fragment.setCurrentJoke(intent.getStringExtra(JOKE_EXTRA));

        }
    }


}
