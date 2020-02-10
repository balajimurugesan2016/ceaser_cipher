package com.cipher.Emblems;

import java.util.HashMap;

public class Emblem{

 private static HashMap <String, Integer> emb;

 public Emblem(){

    emb = new HashMap<String,Integer>();

 }

public void setMap(String alph, Integer occur){
   
    emb.put(alph, occur);
}

public HashMap<String, Integer> getMap(){

return emb;

}








}


