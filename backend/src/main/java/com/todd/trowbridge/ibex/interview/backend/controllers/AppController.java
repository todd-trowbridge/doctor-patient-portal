package com.todd.trowbridge.ibex.interview.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // create rest controller for spring boot
@RequestMapping("/") // create url
public class AppController {

    @GetMapping
    String testApp(){
        return "Hello Spring Security";
    }

    @GetMapping("admin")
    String testAdminAuth(){
        return "admin authentication verified";
    }
}
