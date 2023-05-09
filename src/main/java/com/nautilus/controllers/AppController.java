package com.nautilus.controllers;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class AppController {

    @GetMapping(value = "/{name}")
    public String test(@PathVariable("name") String name) {
        return "Application Docker -> ".concat(name);
    }

    @PostMapping
    public String calc(@PathParam("value") String value) {
        return "A raiz quadrada de "
            .concat(value)
            .concat(" é: ")
            .concat(String.valueOf(Math.sqrt(Double.parseDouble(value))));
    }
}