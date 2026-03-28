package com.url.shortener.controller;

import com.url.shortener.service.UrlServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RedirectController{
    private final UrlServiceImpl service;

    public RedirectController(UrlServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<?> redirect(@PathVariable String shortCode){
        return new ResponseEntity<>(service.getOriginalUrl(shortCode), HttpStatus.FOUND);
    }
}