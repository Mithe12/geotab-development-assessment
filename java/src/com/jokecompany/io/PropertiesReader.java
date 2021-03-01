package com.jokecompany.io;

import com.jokecompany.exception.JokeGeneratorException;

import java.io.*;
import java.util.Properties;

/**
 * PropertiesReader.java : Loads the value as property from configuration files and its implemented as singleton.
 *
 * @author: Mithelash Chandrasekaran
 *
 */

public class PropertiesReader {
    private static PropertiesReader onlyInstance = null;
    private Properties prop;

    /* Constructor to load the configuration file */
    private PropertiesReader() {

        //load properties files
        try (InputStream input = new FileInputStream("./java/src/com/jokecompany/config.properties")) {
            prop = new Properties();
            prop.load(input);


        } catch (IOException e) {
            throw new JokeGeneratorException(e.getMessage());
        }
    }

    /* Methods to get the property of configuration file */
    public String getendpointName(){ return prop.getProperty("endpoint.name"); }
    public String getendpointJoke(){
        return prop.getProperty("endpoint.joke");
    }
    public String getRandom(){ return prop.getProperty("getRandom"); }
    public String getCategory(){
        return prop.getProperty("getCategory");
    }
    public String getSpecificCategory(){
        return prop.getProperty("searchCategory");
    }
    public String getReplaceName(){
        return prop.getProperty("replaceName");
    }
    public int getTimeout(){ return Integer.valueOf(prop.getProperty("timeout")); }

    public static PropertiesReader getInstance() {
        if(onlyInstance == null)  onlyInstance = new PropertiesReader();
        return onlyInstance;
    }


}