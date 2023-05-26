package com.nautilus.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nautilus.entities.Calc;

@RestController
@RequestMapping("/api")
class AppController {

    @GetMapping(value = "/{name}")
    public String test(@PathVariable("name") String name) {
        return "Docker Application AWS-EC2 -> ".concat(name);
    }

    @PostMapping
    public String calc(@RequestBody Calc calc) {
        String msg = "";
        try {
            msg = "A raiz quadrada de "
                .concat(String.valueOf(calc.getValue()))
                .concat(" é: ")
                .concat(String.valueOf(Math.sqrt(calc.getValue())));
        } catch (NumberFormatException e) {
            msg = "O dado informado não é um número. "
                .concat(e.getMessage());
        } catch (NullPointerException e) {
            msg = "O dado informado não pode ser nulo. "
            .concat(e.getMessage());
        }
        
        return msg;
    }
}