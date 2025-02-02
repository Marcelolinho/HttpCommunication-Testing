package com.example.RestTemplate_Testing;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class RestService {

    @Autowired
    private RestTemplate restTemplate;
    private String url = "https://viacep.com.br/ws/01001000/json/";
    private LoggerFactory logger;

//    This is the object return
    public String viacepStringReturn() {
        URI uri;
        try {
            uri = new URI(url);
            return restTemplate.getForObject(new URI(url), String.class);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

//    This is the ResponseEntity return
    public ResponseEntity<String> viacepEntityReturn() {
        URI uri;
        try {
            uri = new URI(url);
            return restTemplate.getForEntity(new URI(url), String.class);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
