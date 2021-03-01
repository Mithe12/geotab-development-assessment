package com.jokecompany.deserializer;

import com.google.gson.*;
import com.jokecompany.model.JokeDTO;

import java.lang.reflect.Type;

/**
 * JokeDeserializer.java : Custom implementation of JsonDeserializer for Joke Object.
 *
 * The JokeDeserializer overrides deserialize methods to map with Joke object.
 *
 * @author  Mithelash Chandrasekaran
 *
 */


public class JokeDeserializer implements JsonDeserializer<JokeDTO> {

    /* Method to deserialize Joke object. */
    @Override
    public JokeDTO deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        return new JokeDTO(
                jsonObject.get("id").getAsString(),
                jsonObject.get("value").getAsString()
        );
    }
}
