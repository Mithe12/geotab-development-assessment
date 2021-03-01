package com.jokecompany.http;
import java.net.http.HttpClient;

/**
 * HttpClientSingleton.java : Singleton implementation of HttpClient.
 *
 * @author  Mithelash Chandrasekaran
 *
 */

class HttpClientSingleton {

    private static HttpClient onlyInstance = null;

    private HttpClientSingleton(){ }

    public static HttpClient getInstance() {
        if(onlyInstance == null)  onlyInstance = HttpClient.newHttpClient();
        return onlyInstance;
    }

}
