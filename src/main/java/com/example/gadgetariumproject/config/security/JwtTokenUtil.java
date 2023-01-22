package com.example.gadgetariumproject.config.security;

import org.springframework.stereotype.Service;

@Service
public class JwtTokenUtil {

    private String secret;
    private String issuer;
    private long expires;


}
