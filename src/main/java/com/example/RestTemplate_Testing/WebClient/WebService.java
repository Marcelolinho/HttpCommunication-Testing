package com.example.RestTemplate_Testing.WebClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class WebService {

    @Autowired
    private WebClient webClient;
    private String getUrl = "https://viacep.com.br/ws/85812475/json/";
    private String postUrl = "https://jsonplaceholder.typicode.com/posts";
    private String putUrl = "https://jsonplaceholder.typicode.com/posts/69";
    private String deleteUrl = "https://jsonplaceholder.typicode.com/posts/69";

//  This is the GET method
    public Mono<String> getMethod() {
        return webClient.get()
                        .uri(getUrl) // Se há alguma URL na config, ele adiciona
                        .exchangeToMono(this::responseHandler);
    }

//  This is the POST method
    public Mono<String> postMethod() {
        Map<String, String> data = new HashMap<>();
        data.put("title", "marcelololo");
        data.put("body", "post usando SPringBoot WebCLient");

        return webClient.post()
                        .uri(postUrl)
                        .bodyValue(data)
                        .exchangeToMono(this::responseHandler);
    }

//  This is the PUT method
    public Mono<String> putMethod() {
        Map<String, String> data = new HashMap<>();

        data.put("body", "put usando SPringBoot WebCLient Marcelololololo");

        return webClient.put()
                        .uri(putUrl)
                        .bodyValue(data)
                        .exchangeToMono(this::responseHandler);
    }

//  This is the DELETE method - Returning STRING as I'm printing it on MAIN
    public Mono<String> deleteMethod() {
        return webClient.delete()
                        .uri(deleteUrl)
                        .exchangeToMono(this::responseHandler);
    }

    private Mono<String> responseHandler(ClientResponse clientResponse) {
        if (clientResponse.statusCode().is2xxSuccessful()) {
            return clientResponse.bodyToMono(String.class);
        } else if (clientResponse.statusCode().is4xxClientError()) {
            return clientResponse.bodyToMono(String.class)
                                 .flatMap(error -> Mono.error(new RuntimeException("Body com valor errado: " + error)));
        } else if (clientResponse.statusCode().is5xxServerError()) {
            return clientResponse.bodyToMono(String.class)
                                 .flatMap(error -> Mono.error(new RuntimeException("Erro de servidor mano: " + error)));
        }
        return clientResponse.bodyToMono(String.class)
                             .flatMap(error -> Mono.error(new RuntimeException("Ocorreu algum erro ao rodar: " + error)));
    }
}