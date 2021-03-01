package com.jokecompany.model;

/**
 * JokeDTO.java : Stores Json data from JokeGenerator
 *
 * @author: Mithelash Chandrasekaran
 *
 */

public class JokeDTO {
    private String jokeId;
    private String jokeText;

    public JokeDTO(String jokeId, String jokeText) {
        this.jokeId = jokeId;
        this.jokeText = jokeText;
    }

    public String getJokeId() {
        return jokeId;
    }

    public void setJokeId(String jokeId) {
        this.jokeId = jokeId;
    }

    public String getJokeText() {
        return jokeText;
    }

    public void setJokeText(String jokeText) {
        this.jokeText = jokeText;
    }

    @Override
    public String toString() {
        return "JokeDTO{" +
                "jokeId='" + jokeId + '\'' +
                ", jokeText='" + jokeText + '\'' +
                '}';
    }
}
