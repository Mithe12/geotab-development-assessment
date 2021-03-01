package com.jokecompany.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jokecompany.deserializer.NameDeserializer;
import com.jokecompany.http.HttpGetter;
import com.jokecompany.model.NameDTO;
import com.jokecompany.io.PropertiesReader;
import java.net.http.HttpResponse;

/**
 * NameGenerator.java: To get random names from names.privserv.com .
 *
 * @author  Mithelash Chandrasekaran
 *
 */


public class NameGenerator implements INameGenerator{

    //get properties
    private PropertiesReader props = PropertiesReader.getInstance();;
    private String nameUrl = props.getendpointName();;

    /* Create a new request and get a random name */
    public NameDTO getNames() {
        HttpGetter httpGetter = new HttpGetter(nameUrl);
        HttpResponse<String> response = httpGetter.execute();
        return buildNameObject(response);
    }

    /* Deserialize the json to name Object */
    private NameDTO buildNameObject(HttpResponse<String> response){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(NameDTO.class, new NameDeserializer())
                .create();
        return gson.fromJson(response.body(), NameDTO.class);
    }
}
