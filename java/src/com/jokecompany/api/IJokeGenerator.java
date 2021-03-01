package com.jokecompany.api;

import com.jokecompany.model.JokeDTO;

import java.util.List;

/**
 * IJokeGenerator.java : Interface for JokeGenerator.
 *
 * The JokeGenerator provides two methods to get the random jokes from ChuckNorris Api.
 * The JokeGenerator provides one methods to get list of categories.
 *
 * @author  Mithelash Chandrasekaran
 *
 */

public interface IJokeGenerator {

    /* Return a random joke */
    JokeDTO getRandomJokes();

    /* Return a random joke based on given category */
    JokeDTO getRandomJokes(String category);

    /* Return list of categories */
    List<String> getCategories();
}
