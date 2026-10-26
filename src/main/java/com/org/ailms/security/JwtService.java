package com.org.ailms.security;

import java.nio.charset.StandardCharsets;
import java.security.KeyStore.SecretKeyEntry;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service 
public class JwtService {
    @Value (value="${jwt.Secret}")
    private String jwtsecret;

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(jwtsecret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(UserDetails userDetails){
        return Jwts.builder().subject(userDetails.getUsername())
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
        .signWith(getSecretKey())
        .compact();

    }

    public Claims parseToken(String token){
        return  Jwts.parser()
        .verifyWith(getSecretKey())
        .build()
        .parseSignedClaims(token)
        .getPayload();
    }
}
