package com.ramiro.restMeasure.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RequestTest {

    @RequestMapping("/")
    String raiz() {
        return "Bienvenido!!!";
    }

    @RequestMapping("saludo")
    String saludo() {
        return "Hola !!!!!!!!!!";
    }  

}