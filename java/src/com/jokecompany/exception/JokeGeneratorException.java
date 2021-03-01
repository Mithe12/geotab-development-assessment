package com.jokecompany.exception;


/**
 * JokeGeneratorException.java : Custom implementation of RuntimeException.
 *
 * @author  Mithelash Chandrasekaran
 *
 */

public class JokeGeneratorException extends RuntimeException {

    public JokeGeneratorException(String message) { super(message); }
    public JokeGeneratorException(String message, Throwable cause) { super(message, cause); }
    public JokeGeneratorException(Throwable cause) {
        super(cause);
    }
}
