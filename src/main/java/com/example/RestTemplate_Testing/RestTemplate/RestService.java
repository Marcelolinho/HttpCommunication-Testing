package com.example.RestTemplate_Testing.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestService {
    private static final Logger logger = LoggerFactory.getLogger(RestService.class);

    @Autowired
    private RestTemplate restTemplate;
    private String getUrl = "https://viacep.com.br/ws/01001000/json/";
    private String postUrl = "https://jsonplaceholder.typicode.com/posts";
    private String putUrl = "https://jsonplaceholder.typicode.com/posts/70";
    private String deleteUrl = "https://jsonplaceholder.typicode.com/posts/70";

//  This is the object return
    public String viacepStringReturn() {
        URI uri;
        try {
            uri = new URI(getUrl);
            return restTemplate.getForObject(new URI(getUrl), String.class);
        } catch (Exception e) {
            logger.error("Erro ao comunicar com a URL: {}", getUrl, e);
            throw new RuntimeException(e);
        }
    }

//  This is the ResponseEntity return
    public ResponseEntity<String> viacepEntityReturn() {
        URI uri;
        try {
            uri = new URI(getUrl);
            return restTemplate.getForEntity(new URI(getUrl), String.class);
        } catch (Exception e) {
            logger.error("Erro ao comunicar com a URL: {}", getUrl, e);
            throw new RuntimeException(e);
        }
    }

//  This is the POST method
    public ResponseEntity<String> postSample() {
        URI uri;

        Map<String, String> postData = new HashMap<>();
        postData.put("title", "marcelo POST");
        postData.put("body", "marcelo body, testing RestTemplate");

        try {
            uri = new URI(postUrl);

            return restTemplate.postForEntity(uri, postData, String.class);
        } catch (Exception e) {
            logger.error("POST deu errado, URL não é correta mano {}", postUrl, e);
            throw new RuntimeException(e);
        }
    }

//  This is the PUT method
    public void putData() {
        Map<String, String> data = new HashMap<>();

        data.put("title", "Marceloliho");

        try {
            URI uri = new URI(putUrl);

            restTemplate.put(uri, data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//  This is the DELETE method
    public void deleteMethod() {
        try {
            URI uri = new URI(deleteUrl);

            restTemplate.delete(uri);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
