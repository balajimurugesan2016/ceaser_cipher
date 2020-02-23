package com.cipher.ceaser;

import com.cipher.Alphabets.Alphabet;
import com.cipher.Emblems.Emblem;
import com.cipher.Kingdoms.Kingdom;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class Main {



public static void main(String... args){

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
    ac.register(Alphabet.class);
    ac.register(Kingdom.class);
    ac.register(CeaserCipher.class);
    ac.refresh();
    CeaserCipher cc = (CeaserCipher)ac.getBean(CeaserCipher.class);
    cc.readInput();
    ac.close();







}




}