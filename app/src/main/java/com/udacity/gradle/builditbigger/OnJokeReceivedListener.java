package com.udacity.gradle.builditbigger;

import br.com.kmg.jokelib.Joke;

public interface OnJokeReceivedListener {

    void displayJoke(Joke joke);
}
