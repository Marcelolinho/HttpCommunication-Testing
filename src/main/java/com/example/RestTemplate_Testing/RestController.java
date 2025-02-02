package com.example.RestTemplate_Testing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/test")
public class RestController {
    @Autowired
    private RestService restService;

    @GetMapping("/object")
    public String getObject() {
        return restService.viacepStringReturn();
    }

    @GetMapping("/entity")
    public ResponseEntity<String> getEntity() {
        return restService.viacepEntityReturn();
    }
}
