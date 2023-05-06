package com.example.springdynamicsecurity.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TopicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        System.out.println("realm entry...");
        response.addHeader("www-Authenticate",
               "Basic realm=\"" + getRealmName() +"\"");

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED
        ,authException.getMessage());
    }

    @Override
    public void afterPropertiesSet() {
       setRealmName("Topic security application realm");
    }
}
