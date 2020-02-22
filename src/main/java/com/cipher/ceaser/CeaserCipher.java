package com.cipher.ceaser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.cipher.Alphabets.Alphabet;
import com.cipher.Emblems.Emblem;
import com.cipher.Kingdoms.Kingdom;

public class CeaserCipher {

    Kingdom kingdom;
    Alphabet alphabet;
    List<String> success; 
    List<String> failure;
   

    public CeaserCipher() {
        kingdom = new Kingdom();
        alphabet = new Alphabet();
        success = new ArrayList<String>();
        failure = new ArrayList<String>();
        success.add("SPACE");
        failure.add("NONE");
    }

    private String[] splitString(String str) {

        return str.split("\\s+",2);

    }

    private Boolean getDecryptString(String message, HashMap<String, Integer> emblem, int kingdomlength){
        int position;
        int calculatedPosition;
        String letter;
        Boolean [] isFlag = {false};
       
      for(int i =0;i<message.length();i++){
        
        letter =  Character.toString(message.charAt(i));
        if(letter.matches("[A-Z]"))
        {
         
        position = alphabet.getAlphabetPositionByLetter(letter);
        calculatedPosition = position - kingdomlength;

        if(calculatedPosition <  1){

            calculatedPosition = 26 + calculatedPosition; 
        }

        letter = alphabet.getAlphabetByposition(calculatedPosition);
    
        if(emblem.containsKey(letter)){

         int value = emblem.get(letter);
         emblem.replace(letter, value, value - 1);

        }
    }
      }

      emblem.forEach((key,value)->{ 
        isFlag[0] = (value > 0)?true:false;                                       
      });
      Boolean result  = (isFlag[0] == false)?true:false;
      return result;
    }

    public String decryptMessage(String message) {
        String[] texts = this.splitString(message);
        String kingdomType = texts[0];
        String Animal = kingdom.getAnimalForKingdom(kingdomType);
        HashMap<String, Emblem> emblems = kingdom.getMap();
        Emblem et = emblems.get(kingdomType);
        HashMap<String, Integer> occurance = et.getMap();
        Boolean isSuccess = this.getDecryptString(texts[1],occurance, Animal.length());
        if(isSuccess){
           return kingdomType;
        }
        else{
            return null;
        }        

    }

    private void readInput() {
        File file = new File("/home/vagrant/testcases1.txt");

        try (Scanner sc = new Scanner(file)) {
        
            while (sc.hasNextLine()) {
                String king = this.decryptMessage(sc.nextLine());
                if ( king != null){
                 success.add(king);
                }
            }
            if(success.size() > 3){

                System.out.println(success);
            }
            else
            {
                System.out.println(failure);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        CeaserCipher ap = new CeaserCipher();
        ap.readInput();

    }
}
