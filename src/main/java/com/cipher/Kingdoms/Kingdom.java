/*************************
 * Bean class to set occurances of characters and kingdom name in emblem into a hashMap structure
 * AUTHOR: Balaji Vengatesh Murugesan
 * Framework: Core java
 * ************ */

package com.cipher.Kingdoms;

import java.util.HashMap;
import com.cipher.Emblems.*;

public class Kingdom {

    HashMap<String, Emblem> kd;


    public Kingdom() {
        kd = new HashMap<String, Emblem>();
        // Set Space
        this.setSpace();
        this.setLand();
        this.setWater();
        this.setIce();
        this.setAir();
        this.setFire();

    }

    public void setSpace() {
        Emblem space = new Emblem();
        space.setMap("G", 1);
        space.setMap("O", 1);
        space.setMap("R", 1);
        space.setMap("I", 1);
        space.setMap("L", 2);
        space.setMap("A", 1);
        kd.put("SPACE", space);
    }

    public void setLand() {
        Emblem land = new Emblem();
        land.setMap("P", 1);
        land.setMap("A", 2);
        land.setMap("N", 1);
        land.setMap("D", 1);

        kd.put("LAND", land);
    
        
    }

    public void setWater() {
        Emblem water = new Emblem();
        water.setMap("O", 2);
        water.setMap("C", 1);
        water.setMap("T", 1);
        water.setMap("P", 1);
        water.setMap("U", 1);
        water.setMap("S", 1);
        kd.put("WATER", water);
    }

    public void setIce() {
        Emblem ice = new Emblem();
        ice.setMap("M", 3);
        ice.setMap("A", 1);
        ice.setMap("O", 1);
        ice.setMap("T", 1);
        ice.setMap("H", 1);
        kd.put("ICE", ice);
    }
    public void setAir(){
        Emblem air = new Emblem();
        air.setMap("O",1);
        air.setMap("W",1);
        air.setMap("L",1);
        kd.put("AIR", air);
       
    }
    public void setFire(){
        Emblem fire = new Emblem();
        fire.setMap("D",1);
        fire.setMap("R",1);
        fire.setMap("A",1);
        fire.setMap("G",1);
        fire.setMap("O",1);
        fire.setMap("N",1);
        kd.put("FIRE", fire);

    }

    public HashMap<String, Emblem> getMap(){

              return kd;

    }

    public String getAnimalForKingdom(String kingType){
         
        switch(kingType){

           case "AIR":
           return "OWL" ;
           case "ICE":
           return "MAMMOTH" ;
           case "FIRE":
           return "DRAGON" ;
           case "LAND":
           return "PANDA" ;
           case "WATER":
           return "OCTOPUS" ;
           case "SPACE":
           return "GORILLA" ;
           default:
           return null;

        }
        

    }

}