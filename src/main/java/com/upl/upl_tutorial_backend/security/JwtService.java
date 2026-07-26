package com.upl.upl_tutorial_backend.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;



@Service
public class JwtService {


    private static final String SECRET_KEY =
            "myverysecretkeymyverysecretkey123456789";


    private SecretKey getSigningKey(){

        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes()
        );

    }



    public String generateToken(
            String email,
            String role
    ){

        return Jwts.builder()

                .subject(email)

                .claim("role", role)

                .issuedAt(new Date())

                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 3600000
                        )
                )

                .signWith(
                        getSigningKey()
                )

                .compact();

    }



    public String extractEmail(
            String token
    ){

        return extractClaims(token)
                .getSubject();

    }



    public String extractRole(
            String token
    ){

        return extractClaims(token)
                .get("role", String.class);

    }



    private Claims extractClaims(
            String token
    ){

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }


}