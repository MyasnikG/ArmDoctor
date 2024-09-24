package com.armdoctor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SwaggerConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;


}
