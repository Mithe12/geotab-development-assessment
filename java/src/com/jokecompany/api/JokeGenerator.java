package com.jokecompany.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jokecompany.http.HttpGetter;
import com.jokecompany.deserializer.JokeDeserializer;
import com.jokecompany.model.JokeDTO;
import com.jokecompany.io.PropertiesReader;

import java.net.http.HttpResponse;
import java.util.List;

/**
 * JokeGenerator.java : To get the random jokes and list of categories from ChuckNorris Api
 *
 * @author  Mithelash Chandrasekaran
 *
 */

public class JokeGenerator implements IJokeGenerator {

    //get properties
    private PropertiesReader props = PropertiesReader.getInstance();
    private String jokeurl = props.getendpointJoke();
    private String random = props.getRandom();
    private String category = props.getCategory();
    private String SpecificCategory = props.getSpecificCategory();

    /* Create a new request and get a random joke */
    public JokeDTO getRandomJokes() {

        String randomUrl = jokeurl+random;
        HttpGetter httpGetter = new HttpGetter(randomUrl);
        HttpResponse<String> response = httpGetter.execute();
        return buildJokeObject(response);
    }

    /* Create a new request and get random joke based on given category */
    public JokeDTO getRandomJokes(String category) {
        String randomUrl = jokeurl+SpecificCategory+category;
        HttpGetter httpGetter = new HttpGetter(randomUrl);
        HttpResponse<String> response = httpGetter.execute();
        return buildJokeObject(response);
    }

    /* Create a new request and get list of categories */
    public List<String> getCategories() {

        String categoryUrl = jokeurl+category;
        HttpGetter httpGetter = new HttpGetter(categoryUrl);
        HttpResponse<String> response = httpGetter.execute();
        return new Gson().fromJson(response.body(),List.class);
    }

    /* Deserialize the json to joke Object */
    private JokeDTO buildJokeObject(HttpResponse<String> response){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(JokeDTO.class, new JokeDeserializer())
                .create();
        return gson.fromJson(response.body(), JokeDTO.class);
    }
}

