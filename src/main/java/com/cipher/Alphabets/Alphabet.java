/*************************
 * Bean class to store Alphabets and their corresponding positions. This is done to prevent conversion overhead from ASCII to text.
 * AUTHOR: Balaji Vengatesh Murugesan
 * Framework: Core java
 * ************ */

package com.cipher.Alphabets;

import java.util.HashMap;

import org.springframework.stereotype.Component;


@Component
public class Alphabet{
private final HashMap <String,Integer> alphabets;
private final String [] alphs = { "A", "B", "C", "D", "E", "F", "G", "H", "I","J","K","L","M", "N", "O", "P", "Q", "R", "S", "T", "U", 
"V", "W", "X", "Y","Z"
};
private Integer count = 1;

public Alphabet(){

    alphabets =  new HashMap<String, Integer>();
    for(String i : alphs){

        alphabets.put(i, count);
        count++;
    }
     
}

public Integer getAlphabetPositionByLetter(String letter){

      return alphabets.get(letter);
}

public String getAlphabetByposition(int position){

if(position > 26 && position < 0){

    return null;
}
else
{
return alphs[position - 1];

}

}




}