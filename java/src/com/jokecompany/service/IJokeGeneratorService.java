package com.jokecompany.service;

import com.jokecompany.model.JokeDTO;

import java.util.List;
/**
 * IJokeGeneratorService.java : Interface for JokeGeneratorService.
 *
 * The IJokeGeneratorService provides three methods to get the random jokes from JokeGenerator API .
 * The IJokeGeneratorService provides one methods to get list of categories.
 * The IJokeGeneratorService provides one methods to set list of categories.
 * The IJokeGeneratorService provides one methods to validate categories from the list.
 *
 * @author  Mithelash Chandrasekaran
 *
 */
public interface IJokeGeneratorService {

    /* Method to return a random joke based on category */
    JokeDTO getRandomJokes(String category);

    /* Method to return a random joke based on category */
    JokeDTO getRandomJokes(String firstname, String surname, String category);

    /* Method to return a number of random joke based on category */
    List<String> getNoOfRandomJokes(String category, int noOfJokes, Boolean isRandomName);

    /* Method to get list of categories */
    List<String> getCategories();

    /* Method to set list of categories */
    void setCategories(List<String> categories);

    /* Method to validate categories from the list */
    boolean isValidCategories(String category);

}
