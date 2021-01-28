package com.kao.consumeruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("buy/{name}")
    public String buyTicket(@PathVariable("name") String name)  {
        String s = restTemplate.getForObject("http://PROVIDER-TICKET/ticket",String.class);
        return name + " ok ticket-> "+ s;
    }
}
