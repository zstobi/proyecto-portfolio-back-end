package com.backendproject.finalap.Security.JWT;

import com.backendproject.finalap.Security.Service.ImpUserDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        AuthCredentials authCredentials = new AuthCredentials();
        
        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        } catch (IOException e) {}        
        
        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                authCredentials.getUser(),
                authCredentials.getPassword(),
                Collections.emptyList()
        );
        
        return getAuthenticationManager().authenticate(usernamePAT);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) 
                                            throws IOException, ServletException {
        
        ImpUserDetails userDetails = (ImpUserDetails) authResult.getPrincipal();
        String token = TokenUtils.createToken(userDetails.getUsername());
        
        response.addHeader("Authorization","Bearer " + token);
        response.getWriter().flush();
        
        super.successfulAuthentication(request, response, chain, authResult);
    }
    
    
}
