package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import br.com.kmg.jokelib.Joke;
import br.com.kmg.jokelib.JokesGenerator;

public class EndpointsAsyncTask extends AsyncTask<OnJokeReceivedListener, Void, Joke> {
    private static MyApi myApiService = null;
    OnJokeReceivedListener listener;

    @Override
    protected Joke doInBackground(OnJokeReceivedListener... params) {
        if(myApiService == null) {  // Only do this once

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        listener = params[0];

        try {
            Joke joke = new Joke();
            String jokeDescription = myApiService.getJoke().execute().getData();
            joke.setJokeDescription(jokeDescription);
            return joke;
        } catch (IOException e) {
            Log.e("EndPointAsyncTask", e.getMessage());
            //return new JokesGenerator().generateJoke();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Joke result) {
        if(listener != null){
            listener.displayJoke(result);
        }

    }

}