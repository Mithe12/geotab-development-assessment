package com.jokecompany.api;


import com.jokecompany.model.NameDTO;

/**
 * INameGenerator.java : Interface for NameGenerator.
 *
 * The NameGenerator provides a methods to get random names from names.privserv.com .
 *
 * @author  Mithelash Chandrasekaran
 *
 */

public interface INameGenerator {

    /* Return a random name */
    NameDTO getNames();
  }


