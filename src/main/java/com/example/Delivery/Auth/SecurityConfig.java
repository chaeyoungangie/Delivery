package com.example.Delivery.Auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
// @EnableWebSecurity(debug=true) //spring security filter가 spring filter chain에 등록된다
@RequiredArgsConstructor
public class SecurityConfig {

  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;

  @Bean //bean defines which URL paths should be secured and which should not
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf().disable() // disable csrf first, rest api이므로 csrf 보안이 필요없으므로 disable처리
        .authorizeHttpRequests() //whitelist requestMatchers
        .requestMatchers("/api/v1/product/**").permitAll()
        .requestMatchers("/api/v1/auth/**").permitAll()
        .anyRequest().authenticated() // but any other request should be authenticated
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // sesstion to be stateless so that it doesn't store it, // jwt token으로 인증하므로 세션은 필요없으므로 생성안함
        .and()
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // jwt token 필터를 id/password 인증 필터 전에 넣는다

    return http.build();
  }
}