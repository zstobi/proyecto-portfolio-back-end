package com.backendproject.finalap.Security;

import com.backendproject.finalap.Security.JWT.JwtAuthenticationFilter;
import com.backendproject.finalap.Security.JWT.JwtAuthorizationFilter;
import com.backendproject.finalap.Security.Service.ImpUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class WebSecurityConfigurer {

    private final ImpUserDetailsService userDetailsService;
    private final JwtAuthorizationFilter jwtAuthFilter;
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authMgr) throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationManager(authMgr);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");
        
        return http
                .cors()
                .and()
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/**")
                // se puede modificar la ruta
                .permitAll()
                .anyRequest()
                .authenticated()
//                .and()
//                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    
//    este metodo se le pasaba como parametro en la linea 61, pero inyectamos algo nuevo al principio del conofigurer
//    @Bean 
//    UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("editor")
//                .password(passEncode().encode("editor"))
//                .roles()
//                .build());
//        return manager;
//    }
    
    @Bean
    AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                   .userDetailsService(userDetailsService)
//                   .passEncode(passEncode())
                   .and()
                   .build();
    }
    
    @Bean
    PasswordEncoder passEncode(){ return new BCryptPasswordEncoder();}
    
//    public static void main(String[] args) {
//        System.out.println("pass: " + new BCryptPasswordEncoder().encode("editor123"));
//    }
}
