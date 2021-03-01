package com.jokecompany.service;
import com.jokecompany.io.PropertiesReader;
import com.jokecompany.model.JokeDTO;
import com.jokecompany.model.NameDTO;
import com.jokecompany.api.IJokeGenerator;
import com.jokecompany.api.INameGenerator;
import com.jokecompany.api.JokeGenerator;
import com.jokecompany.api.NameGenerator;

import java.util.ArrayList;
import java.util.List;



/**
 * JokeGeneratorService.java : Service for JokeGenerator API and NameGenerator API.
 *
 * @author  Mithelash Chandrasekaran
 *
 */

public class JokeGeneratorService implements IJokeGeneratorService {

    //get properties and object of JokeGenerator and NameGenerator
    private PropertiesReader props = PropertiesReader.getInstance();
    private IJokeGenerator jokeGenerator;
    private INameGenerator nameGenerator;
    private String name = props.getReplaceName();
    private List<String> categories;

    public JokeGeneratorService()  {
        jokeGenerator = new JokeGenerator();
        nameGenerator = new NameGenerator();
        categories = jokeGenerator.getCategories();
    }

    /* Method to return a random joke based on category and random name */
    public JokeDTO getRandomJokes(String category){

        // get random name
        NameDTO nameDTO = nameGenerator.getNames();
        return getRandomJokes(nameDTO.getFirstname(),nameDTO.getLastname(),category);
    }

    /* Method to return a random joke based on category and random first name and second name */
    public JokeDTO getRandomJokes(String firstname, String lastname, String category) {

        JokeDTO jokeDTO;

        //choose category
        if (category != null)
            jokeDTO= jokeGenerator.getRandomJokes(category);
        else
            jokeDTO= jokeGenerator.getRandomJokes();

        jokeDTO.setJokeText(replaceNames(firstname,lastname, jokeDTO.getJokeText()));
        return jokeDTO;
    }

    /* Method to return a random joke based on category, no of jokes and random name */
    public List<String> getNoOfRandomJokes(String category, int noOfJokes, Boolean isRandomName) {

        JokeDTO jokeDTO;
        List<String> jokes = new ArrayList<>();

        // get number of jokes
        for(int i=0;i<noOfJokes;i++) {
            if (isRandomName)
                jokeDTO = getRandomJokes(category);
            else
                jokeDTO= getRandomJokes(null,null, category);

            jokes.add(jokeDTO.getJokeText());
        }
        return jokes;
    }

    /* Method to get category list */
    public List<String> getCategories() {
        if(categories.isEmpty()) setCategories(jokeGenerator.getCategories());
        return categories;
    }

    /* Method to set category list */
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    /* Method to check category is valid */
    public boolean isValidCategories(String category){
        return categories.contains(category.toLowerCase());
    }

    /* Helper Method to replace the name in joke */
    private String replaceNames(String firstname, String lastname,String joke){
        if (firstname != null && lastname != null)
        {

            // replace all occurence of the name
            while(joke.indexOf(name) > -1){
                int index = joke.indexOf(name);
                String firstPart = joke.substring(0, index);
                String secondPart = joke.substring(index + name.length());
                joke = firstPart + " " + firstname + " " + lastname + secondPart;
            }
        }
        return joke;
    }
}
