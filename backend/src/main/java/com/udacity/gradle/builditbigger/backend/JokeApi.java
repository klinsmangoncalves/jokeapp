package com.udacity.gradle.builditbigger.backend;

public class JokeApi {

    private String jokeString;

    public String getData() {
        return jokeString;
    }

    public void setData(String joke) {
        jokeString = joke;
    }
}
