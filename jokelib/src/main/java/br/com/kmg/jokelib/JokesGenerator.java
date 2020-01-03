package br.com.kmg.jokelib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokesGenerator {

    public Joke generateJoke(){
        List<String> jokes = new ArrayList<>();
        jokes.add("To understand what recursion is, you must first understand recursion.");
        jokes.add("There are 10 kinds of people in the world: Those that know binary & those that don’t");
        jokes.add("If Java is the answer, it must have been a really verbose question.");
        Joke joke = new Joke();
        joke.setJokeDescription(jokes.get(new Random().nextInt(jokes.size())));
        return joke;
    }

}
