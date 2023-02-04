package com.naves.tiposdenaves.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inicio")
public class NavesControlador {
    @GetMapping("/naves")
    public String ingresar(){
        return "Bienvenido a naves espaciales";
    }
}
