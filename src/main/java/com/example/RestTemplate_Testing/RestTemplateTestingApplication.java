package com.example.RestTemplate_Testing;

import com.example.RestTemplate_Testing.RestTemplate.RestService;
import com.example.RestTemplate_Testing.WebClient.WebService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class RestTemplateTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateTestingApplication.class, args);
    }

    @Component
    static
    class AppRunner implements CommandLineRunner {

        private final RestService restService;
        private final WebService webService;

        // Constructor injection of beans
        public AppRunner(RestService restService, WebService webService) {
            this.restService = restService;
            this.webService = webService;
        }

        @Override
        public void run(String... args) {
            System.out.println("GET síncrono (RestTemplate), retornando Objeto");
            System.out.println("\n" + restService.viacepStringReturn() + "\n");

            System.out.println("GET síncrono (RestTemplate), retornando Entidade");
            System.out.println("\n" + restService.viacepEntityReturn() + "\n");

            System.out.println("GET assíncrono (WebClient)");
            System.out.println("\n" + webService.getMethod().block() + "\n");

            System.out.println("POST síncrono (RestTemplate)");
            System.out.println("\n" + restService.postSample() + "\n");

            System.out.println("POST assíncrono (WebClient)");
            System.out.println("\n" + webService.postMethod().block() + "\n");

            System.out.println("PUT síncrono (RestTemplate)");
            System.out.println("\nEsse método não retorna nada, ou seja, não é flexível\n");

            System.out.println("put assíncrono (WebClient)");
            System.out.println("\n" + webService.putMethod().block() + "\n");

            System.out.println("Delete síncrono (RestTemplate)");
            System.out.println("\nEsse método também não retorna nada, nada flexível.\n");

            System.out.println("Delete assíncrono (WebClient)");
            System.out.println("\n" + webService.deleteMethod().block() + "\n");
        }
    }

}
