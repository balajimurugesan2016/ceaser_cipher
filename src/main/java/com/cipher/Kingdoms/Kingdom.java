/*************************
 * Bean class to set occurances of characters and kingdom name in emblem into a hashMap structure
 * AUTHOR: Balaji Vengatesh Murugesan
 * Framework: Core java
 * ************ */

package com.cipher.Kingdoms;

import java.util.HashMap;
import com.cipher.Emblems.Emblem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;


@Component
public class Kingdom  {
   
    HashMap<String, Emblem> kd;
    @Autowired
    private Emblem emblem;
  

    public Kingdom() {

        
      
        kd = new HashMap<String, Emblem>();
    }

    @Lookup
    public Emblem getEmblemProtoBean() {
        return null;
    }

    public void instantiateEmblems(){
        this.setSpace();
        this.setLand();
        this.setWater();
        this.setIce();
        this.setAir();
        this.setFire();

    }

    public void setSpace() {

        emblem = getEmblemProtoBean();
        emblem.setMap("G", 1);
        emblem.setMap("O", 1);
        emblem.setMap("R", 1);
        emblem.setMap("I", 1);
        emblem.setMap("L", 2);
        emblem.setMap("A", 1);
        kd.put("SPACE", emblem);
    }

    public void setLand() {
      
        // Emblem land = new Emblem();
        emblem = getEmblemProtoBean();
        emblem.setMap("P", 1);
        emblem.setMap("A", 2);
        emblem.setMap("N", 1);
        emblem.setMap("D", 1);

        kd.put("LAND", emblem);

    }

    public void setWater() {
        // Emblem water = new Emblem();
        emblem = getEmblemProtoBean();
        emblem.setMap("O", 2);
        emblem.setMap("C", 1);
        emblem.setMap("T", 1);
        emblem.setMap("P", 1);
        emblem.setMap("U", 1);
        emblem.setMap("S", 1);
        kd.put("WATER", emblem);
    }

    public void setIce() {
        // Emblem ice = new Emblem();
        emblem = getEmblemProtoBean();
        emblem.setMap("M", 3);
        emblem.setMap("A", 1);
        emblem.setMap("O", 1);
        emblem.setMap("T", 1);
        emblem.setMap("H", 1);
        kd.put("ICE", emblem);
    }

    public void setAir() {
        // Emblem air = new Emblem();
        emblem = getEmblemProtoBean();
        emblem.setMap("O", 1);
        emblem.setMap("W", 1);
        emblem.setMap("L", 1);
        kd.put("AIR", emblem);

    }

    public void setFire() {
        // Emblem fire = new Emblem();
        emblem = getEmblemProtoBean();
        emblem.setMap("D", 1);
        emblem.setMap("R", 1);
        emblem.setMap("A", 1);
        emblem.setMap("G", 1);
        emblem.setMap("O", 1);
        emblem.setMap("N", 1);
        kd.put("FIRE", emblem);

    }

    public HashMap<String, Emblem> getMap() {

        return kd;

    }

    public String getAnimalForKingdom(String kingType) {

        switch (kingType) {

        case "AIR":
            return "OWL";
        case "ICE":
            return "MAMMOTH";
        case "FIRE":
            return "DRAGON";
        case "LAND":
            return "PANDA";
        case "WATER":
            return "OCTOPUS";
        case "SPACE":
            return "GORILLA";
        default:
            return null;

        }

    }

}