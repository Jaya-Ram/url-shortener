package com.url.shortener.controller;

import com.url.shortener.dto.UrlRequest;
import com.url.shortener.service.UrlServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class UrlController{
    private final UrlServiceImpl service;

    public UrlController(UrlServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public String shorten(@RequestBody UrlRequest request){
        String code = service.shortenUrl(request.getUrl());
        return "http://localhost:8080/api/" + code;
    }
}
