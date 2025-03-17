package com.jobify.Jobify.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    private String secretKey = "pN33mJ8DP8UdPZ8EDglpbXoDBa3RD17f";


    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(SignatureAlgorithm.ES256,secretKey)
                .compact();
    }

    public Boolean validateToken(String token,String email){
        String emailFromToken = extractUsername(email);
        return (emailFromToken.equals(email) && isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    private Claims extractClaims(String token){
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token){
        return extractClaims(token).getExpiration().before(new Date());
    }

}
