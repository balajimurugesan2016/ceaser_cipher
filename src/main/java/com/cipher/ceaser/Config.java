package com.cipher.ceaser;

import com.cipher.Alphabets.Alphabet;
import com.cipher.Emblems.Emblem;
import com.cipher.Kingdoms.Kingdom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

class Config{

@Bean
public Kingdom createkingdom(){

    return new Kingdom();
}



@Bean
public Alphabet createAlphabet(){

    return new Alphabet();
}





}