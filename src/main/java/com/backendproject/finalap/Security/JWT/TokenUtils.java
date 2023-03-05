package com.backendproject.finalap.Security.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class TokenUtils {
    
    private final static String ACCESS_TOKEN_SECRET = "ed3ba9be9c7d6f770b91ad9353c42329";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 10_368_000L;
    
    public static String createToken(String user){
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("user", user);
        
        return Jwts.builder()
                   .setExpiration(expirationDate)
                   .addClaims(extra)
                   .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                   .compact();
    }
    
    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
            Claims claims = Jwts.parserBuilder()
                            .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                            .build()
                            .parseClaimsJws(token)
                            .getBody();
        
            String username = claims.getSubject();
        
            return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
        } catch (JwtException e) {
            return null;
        }
    }
}
