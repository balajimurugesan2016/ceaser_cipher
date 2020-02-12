package com.cipher.ceaser;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import com.cipher.Emblems.Emblem;
import com.cipher.Kingdoms.Kingdom;


public class CeaserCipher {

    Kingdom kingdom;

    public CeaserCipher(){
        kingdom = new Kingdom();
    }

    public String[] splitString(String str){

        return str.split("\\s+");

        
     }

     public String decryptMessage(String message){
        String []texts =  this.splitString(message);
        String kingdomType  = texts[0];
        String Animal = kingdom.getAnimalForKingdom(kingdomType);
        HashMap<String,Emblem> emblems = kingdom.getMap();
        Emblem et = emblems.get(kingdomType);
        HashMap <String, Integer> occurance = et.getMap();
         return null;



     }

    private void readInput() {
        File file = new File("/home/vagrant/testcases.txt");

        try (Scanner sc = new Scanner(file)) {

            while(sc.hasNextLine()){

             this.decryptMessage(sc.nextLine());

            }   
           
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    public static void main( String[] args )
    {
        CeaserCipher ap = new CeaserCipher();
        ap.readInput();
        



    }
}
