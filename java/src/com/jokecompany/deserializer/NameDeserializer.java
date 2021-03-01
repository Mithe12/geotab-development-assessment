package com.jokecompany.deserializer;

import com.google.gson.*;
import com.jokecompany.model.NameDTO;

import java.lang.reflect.Type;


/**
 * NameDeserializer.java : Custom implementation of JsonDeserializer for Name Object.
 *
 * The NameDeserializer overrides deserialize methods to map with Name object.
 *
 * @author  Mithelash Chandrasekaran
 *
 */

public class NameDeserializer implements JsonDeserializer<NameDTO> {

    /* Method to deserialize Name object. */
    @Override
    public NameDTO deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        return new NameDTO(
                jsonObject.get("name").getAsString(),
                jsonObject.get("surname").getAsString()
        );
    }
}
