package com.jokecompany.test;
import com.jokecompany.api.IJokeGenerator;
import com.jokecompany.api.INameGenerator;
import com.jokecompany.api.JokeGenerator;
import com.jokecompany.api.NameGenerator;
import com.jokecompany.http.HttpGetter;
import com.jokecompany.model.JokeDTO;
import com.jokecompany.model.NameDTO;
import com.jokecompany.service.IJokeGeneratorService;
import com.jokecompany.service.JokeGeneratorService;

import java.net.http.HttpResponse;
import java.util.List;

/**
 * Test.java : Used to test various parts of the application.
 *
 * @author  Mithelash Chandrasekaran
 *
 */


public class Test {

    public static void main(String[] args) {

        // Test for connections
        testForConnection();

        // Test for JokeGenerator
        testForJokeGenerator();

        // Test for NameGenerator
        testForNameGenerator();

        // Test for JokeGeneratorService
        testForJokeGeneratorService();
    }


    private static void testForConnection() {
        String categoryUrl = "https://api.chucknorris.io/jokes/categories";
        HttpGetter httpGetter = new HttpGetter(categoryUrl);
        HttpResponse response = httpGetter.execute();
        System.out.println(response.body());
    }

    private static void testForJokeGeneratorService(){

        IJokeGeneratorService jokeGeneratorService = new JokeGeneratorService();

        //getRandomJokes with values
        String category = "dev";
        JokeDTO jokeDTO = jokeGeneratorService.getRandomJokes(category);
        System.out.println(jokeDTO.toString());

        //getRandomJokes with name and category values
        String firstName = "John", lastName = "Doe";
        jokeDTO = jokeGeneratorService.getRandomJokes(firstName,lastName,category);
        System.out.println(jokeDTO.toString());

        //getRandomJokes with category is null
        category = null;
        jokeDTO = jokeGeneratorService.getRandomJokes(category);
        System.out.println(jokeDTO.toString());

        //getRandomJokes with name value and category is null
        jokeDTO = jokeGeneratorService.getRandomJokes(firstName,lastName,category);
        System.out.println(jokeDTO.toString());

        //getNoOfRandomJokes with category, noOfJokes and isRandom
        int noOfJokes = 6;
        Boolean isRandomName = false;
        List<String> listOfJokes = jokeGeneratorService.getNoOfRandomJokes(category,noOfJokes,isRandomName);
        System.out.println(listOfJokes.toString());

        //get Categories
        List<String> categories = jokeGeneratorService.getCategories();
        System.out.println(categories.toString());

        //valid category
        Boolean isTrue = jokeGeneratorService.isValidCategories("dev");
        Boolean isFalse = jokeGeneratorService.isValidCategories("xxdev");
        System.out.println(isTrue);
        System.out.println(isFalse);

    }
    private static void testForJokeGenerator() {

        IJokeGenerator jokeGenerator = new JokeGenerator();

        //get RandomJokes
        JokeDTO jokeDTO = jokeGenerator.getRandomJokes();
        System.out.println(jokeDTO.toString());

        //get RandomJokes with Category
        String category = "dev";
        jokeDTO = jokeGenerator.getRandomJokes(category);
        System.out.println(jokeDTO.toString());

        //get Categories
        List<String> result = jokeGenerator.getCategories();
        System.out.println(result.toString());
    }

    private static void testForNameGenerator() {

        INameGenerator nameGenerator = new NameGenerator();

        //get RandomJokes
        NameDTO nameDTO = nameGenerator.getNames();
        System.out.println(nameDTO.toString());

    }
}