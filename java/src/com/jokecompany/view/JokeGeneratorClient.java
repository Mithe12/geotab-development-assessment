package com.jokecompany.view;

import com.jokecompany.service.IJokeGeneratorService;
import com.jokecompany.service.JokeGeneratorService;
import com.jokecompany.io.ConsolePrinter;
import com.jokecompany.io.ConsoleReader;
import java.util.List;

/**
 * JokeGeneratorClient.java : Client for JokeGenerator Service.
 *
 * @author  Mithelash Chandrasekaran
 *
 */

public class JokeGeneratorClient {

    //get object of JokeGeneratorService, ConsolePrinter and ConsoleReader
    private IJokeGeneratorService jokeGeneratorService = new JokeGeneratorService();
    private ConsolePrinter printer = new ConsolePrinter();
    private ConsoleReader reader = new ConsoleReader();

    /* Method to initialize the client */
    public void init() {

        printer.Value("************* Welcome to Chuck Norris Joke Generator ******************");
        printer.Value("************* Press ? to get instructions *************************");
        doInteractions();
    }

    /* Helper Method to interact with user */
    private void doInteractions() {

        char keyPress;
        while(true) {
            
            // menu operations
            keyPress = reader.readUserInputInstructions();
            if(keyPress == '?') printInstructions();
            else if(keyPress == 'c') {
                printCategories();
                printInstructions();
            }
            else if(keyPress == 'r') printJokes();
            else if(keyPress == 'q') break;
            else printer.Value("!-- Command is invalid. Please type a valid command --!");
        }
    }

    /* Helper Method to print jokes for user */
    private void printJokes() {

        Boolean isRandomName = false;
        String category = null;
        char keyPress;

        // Choosing the random name
        printer.Value("******* Press ? to return to main menu *******");
        printer.Value("??? Want to use a random name? y/n ???");
        keyPress = reader.readUserInputYesOrNo();
        while(keyPress == 'x') {
            printer.Value("!-- Command is invalid. Please type y/n --!");
            keyPress = reader.readUserInputYesOrNo();
        }
        if(keyPress == 'y')  isRandomName = true;
        if(keyPress == '?') {
            printInstructions();
            return;
        }

        // Choosing the category
        printer.Value("??? Want to specify a category? y/n???");
        keyPress = reader.readUserInputYesOrNo();
        while(keyPress == 'x') {
            printer.Value("!-- Command is invalid. Please type y/n--!");
            keyPress = reader.readUserInputYesOrNo();
        }
        if(keyPress == '?') {
            printInstructions();
            return;
        }
        if(keyPress == 'y') {
            printer.Value("??? Please choose the category ???");
            category = reader.readUserInputCategory();
            while(category != null && !jokeGeneratorService.isValidCategories(category)){
                printer.Value("!-- Category is not valid. Please enter a valid category --!");
                category = reader.readUserInputCategory();
                if(category.equals("?")) {
                    printInstructions();
                    return;
                }
            }
        }

        //choosing the jokes
        printer.Value("??? How many jokes do you want? (1-9) ???");
        keyPress = reader.readUserInputNumbers();
        while(keyPress == 'x') {
            printer.Value("!-- Command is invalid. Please number in range 1-9 --!");
            keyPress = reader.readUserInputNumbers();
        }
        if(keyPress == '?') {
            printInstructions();
            return;
        }
        int noOfJokes = Integer.parseInt(String.valueOf(keyPress));
        List<String> jokes = jokeGeneratorService.getNoOfRandomJokes(category,noOfJokes,isRandomName);
        printer.Value(jokes);
        printer.Value("********** Jokes Generated ************* ");
        printer.Value("********** Please ? to Main menu *******");
    }

    /* Helper Method to print categories for user */
    private void printCategories(){
        List<String> categories = jokeGeneratorService.getCategories();
        printer.Value(categories.toString());
    }

    /* Helper Method to print instruction for user */
    private void printInstructions(){
        printer.Value("******* Main Menu *******");
        printer.Value("??? Press c to get categories ???");
        printer.Value("??? Press r to get random jokes ???");
        printer.Value("??? Press q to get random jokes ???");
        printer.Value("**********************");
    }
}
