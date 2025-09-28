package com.refractorx95.Book_demo.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {

    public String generateToken(String username);

    public String extractUserName(String jwtToken);

    boolean validateToken(String jwtToken, UserDetails userDetails);
}
