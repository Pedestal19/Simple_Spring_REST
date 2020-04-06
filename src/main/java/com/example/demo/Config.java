package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class Config extends WebMvcConfigurerAdapter {

    @Autowired
    AuthenticationInterceptor handlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(handlerInterceptor);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

   /* @Bean
    public Map<String, String> myMap() {
        final Map<String, String> myMap = new HashMap<>();
        myMap.put("A", "a");
        return myMap;
    }

    @Bean
    public Map <String, String> myMap2(String x, String y) {
        final Map<String, String> myMap = new HashMap<>();
        myMap.put("A", "a");
        return myMap;
    }

    @Bean
    public User user(Map<String,String> books){
        books.put("A", "a");
    }*/
}
