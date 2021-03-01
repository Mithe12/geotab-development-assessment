package com.jokecompany.model;

/**
 * NameDTO.java : Stores Json data from NameGenerator
 *
 * @author: Mithelash Chandrasekaran
 *
 */

public class NameDTO {
    private String firstname , lastname;

    public NameDTO(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "NameDTO{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
