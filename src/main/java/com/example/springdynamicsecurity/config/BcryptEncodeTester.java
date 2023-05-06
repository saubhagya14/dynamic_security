package com.example.springdynamicsecurity.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncodeTester {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        System.out.println("Password for Saubhagya : " + bCryptPasswordEncoder.encode("Saubhagya"));
        System.out.println("Password for Padmalaya : " + bCryptPasswordEncoder.encode("Padma"));

    }
}
