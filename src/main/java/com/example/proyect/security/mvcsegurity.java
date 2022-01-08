package com.example.proyect.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class mvcsegurity implements WebMvcConfigurer{
    
    public BCryptPasswordEncoder passEncoder(){
        return new BCryptPasswordEncoder();
    }
}
