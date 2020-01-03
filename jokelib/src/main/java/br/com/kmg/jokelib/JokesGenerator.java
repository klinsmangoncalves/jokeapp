package br.com.kmg.jokelib;

public class JokesGenerator {

    public Joke generateJoke(){
        Joke joke = new Joke();
        joke.setJokeDescription("To understand what recursion is, you must first understand recursion.");
        return joke;
    }

}
