package com.jokecompany.io;

import com.jokecompany.exception.JokeGeneratorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * ConsoleReader.java : Reads user input
 *
 * @author: Mithelash Chandrasekaran
 *
 */

public class ConsoleReader {

    // BufferedReader to get the console inputs
    private BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));


    /* Method to read user input instruction, if not valid character returns x */
    public char readUserInputInstructions() {
        String userInput = readUserInput();
        if(!userInput.equals("") && userInput.length() == 1) {
            char ch = userInput.charAt(0);
            if (Character.isLetter(ch) && (Character.toLowerCase(ch) == 'c' || Character.toLowerCase(ch) == 'r' || Character.toLowerCase(ch) == 'q'))
                return Character.toLowerCase(ch);
            else if (ch == '?')
                return ch;
        }
        return 'x';
    }

    /* Method to read user input yes or no, if not valid character returns x */
    public char readUserInputYesOrNo() {
        String userInput = readUserInput();
        if(!userInput.equals("") && userInput.length() == 1) {
            char ch = userInput.charAt(0);
            if (Character.isLetter(ch) && ( Character.toLowerCase(ch) == 'y' || Character.toLowerCase(ch) == 'n') )
                return Character.toLowerCase(ch);
            else if (ch == '?')
                return ch;
        }
        return 'x';
    }

    /* Method to read user input number, if not valid character returns x */
    public char readUserInputNumbers(){
        String userInput = readUserInput();
        if(!userInput.equals("") && userInput.length() == 1) {
            char ch = userInput.charAt(0);
           if (Character.isDigit(ch) && (Character.getNumericValue(ch) > 0 && Character.getNumericValue(ch) <= 9))
                return ch;
           else if (ch == '?')
               return ch;
        }
        return 'x';
    }

    /* Method to read user input as string , if not valid character returns x */
    public String readUserInputCategory() {
       return readUserInput();
    }

    /* Helper Method to read user input instruction as string */
    private String readUserInput(){
        try {
            return bReader.readLine();
        } catch (IOException e){
            throw new JokeGeneratorException(e.getMessage());
        }
    }
}