package com.example.Crud.controller;

import com.example.Crud.Entity.User;
import com.example.Crud.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Authentication {


    @Autowired
    private AuthenticationManager authenticationManagaer;
    @Autowired
    JwtUtil jwtUtil;
    @PostMapping("/signup")
    public  void signup(@RequestBody User user){

    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
     try{
         log.info("userdtails password is given by yash",authenticationManagaer.authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword())));
String token=jwtUtil.generateToken(user.getName());
return new ResponseEntity<>(token, HttpStatus.OK);
     } catch (Exception e) {
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     }
    }

}
