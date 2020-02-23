/*************************
 * Main Class to decrypt the given message from a file using ceaser cipher
 * AUTHOR: Balaji Vengatesh Murugesan
 * Framework: Core java
 * ************ */
package com.cipher.ceaser;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.cipher.Alphabets.Alphabet;
import com.cipher.Emblems.Emblem;
import com.cipher.Kingdoms.Kingdom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CeaserCipher {

    @Autowired 
    Kingdom kingdom;
    @Autowired
    Alphabet alphabet;
    List<String> success; 
    List<String> failure;
   

    public CeaserCipher() {
        success = new ArrayList<String>();
        failure = new ArrayList<String>();
        success.add("SPACE");
        failure.add("NONE");
    }

    private String[] splitString(final String str) {

        return str.split("\\s+", 2); // Split string based on first occurance, stop checking further occurances of
                                     // white spaces in strings

    }

    private Boolean isEmbleminMessage(final String message, final HashMap<String, Integer> emblem,
            final int kingdomlength) {
        int position;
        int calculatedPosition;
        String letter;
        final Boolean[] isFlag = { false };

        // Loops every letter in message and calculates the position w.r.t length of the
        // emblem
        // If letter is found in the emblem subtract one from the value.

        for (int i = 0; i < message.length(); i++) {

            letter = Character.toString(message.charAt(i));
            if (letter.matches("[A-Z]")) {

                position = alphabet.getAlphabetPositionByLetter(letter);
                calculatedPosition = position - kingdomlength;

                if (calculatedPosition < 1) {

                    calculatedPosition = 26 + calculatedPosition;
                }

                letter = alphabet.getAlphabetByposition(calculatedPosition);

                if (emblem.containsKey(letter)) {

                    final int value = emblem.get(letter);
                    emblem.replace(letter, value, value - 1);

                }
            }
        }

        emblem.forEach((key, value) -> {
            isFlag[0] = (value > 0) ? true : false;
        });
        final Boolean result = (isFlag[0] == false) ? true : false; // Return result
        return result;
    }

    // Decrypt the message and return kingdom type
    private String decryptMsgGetkingdomType(final String message) {
        final String[] texts = this.splitString(message);
        final String kingdomType = texts[0];
        final String Animal = kingdom.getAnimalForKingdom(kingdomType); // Get Animal emblem
        final HashMap<String, Emblem> emblems = kingdom.getMap();
        final Emblem et = emblems.get(kingdomType);
        final HashMap<String, Integer> occurance = et.getMap();
        final Boolean isSuccess = this.isEmbleminMessage(texts[1], occurance, Animal.length()); // Check if emblem is
                                                                                                // present in message
                                                                                                // using ceaser cpher
        if (isSuccess) {
            return kingdomType;
        } else {
            return null;
        }

    }

    // Read the input file from directory and print the success or failure of the
    // conquest
    public void readInput() {
        final File file = new File("/home/vagrant/testcases1.txt");

        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {
                final String king = this.decryptMsgGetkingdomType(sc.nextLine());
                if (king != null) { // Add kingdoms present in the message to success
                    success.add(king);
                }
            }
            if (success.size() > 3) { // Print success only if three or more kingdoms accept

                System.out.println(success);
            } else // Print NONE if less than 3 kingdoms
            {
                System.out.println(failure);
            }

        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }

    }

   
}
