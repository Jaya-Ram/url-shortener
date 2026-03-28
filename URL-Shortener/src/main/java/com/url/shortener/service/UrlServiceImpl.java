package com.url.shortener.service;

import com.url.shortener.model.UrlMapping;
import com.url.shortener.repository.UrlRepository;
import com.url.shortener.util.Base62Encoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService{

    private final UrlRepository repo;

    @Override
    public String shortenUrl(String longUrl) {

        // Save initial Entity
        UrlMapping mapping = UrlMapping.builder()
                .longUrl(longUrl)
                .createdAt(LocalDateTime.now())
                .build();

        mapping = repo.save(mapping);

        // Generate Short Code
        String shortCode = Base62Encoder.encode(mapping.getId());

        // Update Entity
        mapping.setShortCode(shortCode);

        // Save into db
        repo.save(mapping);

        return shortCode;
    }

    @Override
    public UrlMapping getOriginalUrl(String shortCode) {
        return repo.findByShortCode(shortCode)
                .orElseThrow(()-> new RuntimeException("URL not found"));
    }
}
