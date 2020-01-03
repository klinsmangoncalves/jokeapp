package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;
import android.util.Log;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.kmg.jokelib.Joke;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest implements OnJokeReceivedListener {

    @Test
    public void testAsyncTask() {
        final EndpointsAsyncTask asyncTask = new EndpointsAsyncTask();

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                asyncTask.execute(this);
            }
        });

    }

    @Override
    public void displayJoke(Joke joke) {
        Assert.assertNotNull("Joke is null", joke);
        Assert.assertFalse("Joke is empty", TextUtils.isEmpty(joke.getJokeDescription()));

    }
}