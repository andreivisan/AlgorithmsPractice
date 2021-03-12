package io.programminglife.algoexpert.easy;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    public static boolean generateDocument(String characters, String document) {
        Map<Character, Integer> charFreq = new HashMap<Character, Integer>();

        for (int i = 0; i < characters.length(); i++) {
            Character current = characters.charAt(i);
            charFreq.put(current, charFreq.getOrDefault(current, 0) + 1);
        }

        for (int i = 0; i < document.length(); i++) {
            Character current = document.charAt(i);
            if (!charFreq.containsKey(current) || charFreq.get(current) == 0) {
                return false;
            }
            charFreq.put(current, charFreq.get(current) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";

        System.out.println(generateDocument(characters, document));
    }

}
