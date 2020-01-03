package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.imageactivity.ImageActivity;

import br.com.kmg.jokelib.Joke;
import br.com.kmg.jokelib.JokesGenerator;


public class MainActivity extends AppCompatActivity implements OnJokeReceivedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
//        Joke joke = new JokesGenerator().generateJoke();
//        displayJoke(joke);
        new EndpointsAsyncTask().execute(this);
    }

    @Override
    public void displayJoke(Joke joke){

        Log.d("MAIN_ACT_", "displayJoke");
        if(joke != null){
            Toast.makeText(this, joke.getJokeDescription(), Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(this, ImageActivity.class);
            myIntent.putExtra(ImageActivity.JOKE_EXTRA, joke.getJokeDescription());
            startActivity(myIntent);
        }

    }



}
