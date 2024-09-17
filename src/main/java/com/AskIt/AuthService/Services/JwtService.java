package com.AskIt.AuthService.Services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Value("${jwt.secretKey}")
    private String SecretKey;

    @Value("${jwt.expiry}")
    private int expiry;



    public String createJwtToken(Map<String,Object> payload,String userName){

         return Jwts.builder()
                 .claims(payload)
                .subject(userName)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+expiry*1000L))
                .signWith(getSignKey())
                .compact();

    }

    public SecretKey getSignKey() {
        System.out.println(SecretKey);

        return Keys.hmacShaKeyFor(SecretKey.getBytes(StandardCharsets.UTF_8));


    }



    public String createToken(String email) {

        return createJwtToken(new HashMap<>(),email);

    }
}
