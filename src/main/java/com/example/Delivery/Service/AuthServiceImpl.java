package com.example.Delivery.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Delivery.auth.JwtService;
import com.example.Delivery.dto.AuthenticationResponse;
import com.example.Delivery.dto.ChangeAccountRequest;
import com.example.Delivery.dto.LoginRequest;
import com.example.Delivery.dto.RegisterRequest;
import com.example.Delivery.model.Role;
import com.example.Delivery.model.Users;
import com.example.Delivery.repository.UsersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UsersRepository userrepository;
    private final PasswordEncoder passencoder;
    private final JwtService jwtservice;
    private final AuthenticationManager authmanager;

    /*
     * parameter(in): RegisterRequest
     * return(out): AuthenticationResponse
     * purpose: register the user 
     */
    public AuthenticationResponse register(RegisterRequest request) {
        var user = Users.builder()
                        .firstname(request.getFirstname())
                        .lastname(request.getLastname())
                        .email(request.getEmail())
                        .username(request.getUsername())
                        .password(passencoder.encode(request.getPassword()))
                        .role(Role.USER)
                        .build();
        userrepository.save(user);

        var jwttoken = jwtservice.generateToken(user);
        return AuthenticationResponse.builder().token(jwttoken).build();
    }

    /*
     * parameter(in): LoginRequest
     * return(out): AuthenticationResponse
     * purpose: authenticate the user
     */
    public AuthenticationResponse login(LoginRequest request) {
        authmanager.authenticate(new UsernamePasswordAuthenticationToken(
                                    request.getUsername(),
                                    request.getPassword()
        ));
        var user = userrepository.findByUsername(request.getUsername()).orElseThrow();

        var jwttoken = jwtservice.generateToken(user);
        return AuthenticationResponse.builder().token(jwttoken).build();
    }

    /*
     * parameter(in): ChangeAccountRequest
     * return(out): AuthenticationResponse
     * purpose: change user's account info
     */
    public AuthenticationResponse change(ChangeAccountRequest request) {
        var username = jwtservice.extractUsername(request.getToken());
        var user = userrepository.findByUsername(username).orElseThrow();        
        user.setEmail(request.getEmail());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setPassword(passencoder.encode(request.getPassword()));

        userrepository.save(user);

        var jwttoken = jwtservice.generateToken(user);
        return AuthenticationResponse.builder().token(jwttoken).build();
    }

    
}
