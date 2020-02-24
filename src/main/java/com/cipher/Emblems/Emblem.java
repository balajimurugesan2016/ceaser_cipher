/*************************
 * Bean class to retreive emblems for different kingdoms. 
 * AUTHOR: Balaji Vengatesh Murugesan
 * Framework: Core java
 * ************ */
package com.cipher.Emblems;

import java.util.HashMap;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Emblem{

 private  HashMap <String, Integer> emb;


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


