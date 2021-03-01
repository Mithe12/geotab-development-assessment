package com.jokecompany.http;

import com.jokecompany.exception.JokeGeneratorException;
import com.jokecompany.io.PropertiesReader;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpConnectTimeoutException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * HttpGetter.java : Sends request and gets the response for any provided url.
 *
 * @author  Mithelash Chandrasekaran
 *
 */

public class HttpGetter{

    // get properties
    private PropertiesReader props = PropertiesReader.getInstance();
    private int TimeOut = props.getTimeout();
    private HttpRequest request = null;

    /* Constructor to builds the request object */
    public HttpGetter(String url)  {

        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .timeout(Duration.ofMillis(TimeOut))
                    .build();
        } catch (URISyntaxException e){
            throw new JokeGeneratorException(e.getMessage());
        }
    }

    /* Method to executes the request object and gets the response */
    public HttpResponse execute(){

        try {
            HttpClient httpClient = HttpClientSingleton.getInstance();
            HttpResponse<String> response;
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                return response;
            }else {
                JokeGeneratorException e = new JokeGeneratorException(response.toString());
                throw e;
            }
        }catch (HttpConnectTimeoutException e){
            throw new JokeGeneratorException(e.getMessage());
        }catch (IOException | InterruptedException e){
            throw new JokeGeneratorException(e.getMessage());
        }
    }
}
