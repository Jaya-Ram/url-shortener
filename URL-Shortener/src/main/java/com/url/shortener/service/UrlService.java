package com.url.shortener.service;

import com.url.shortener.model.UrlMapping;

public interface UrlService {
    String shortenUrl(String longUrl);
    UrlMapping getOriginalUrl(String shortCode);
}
