package io.programminglife.algoexpert.easy;

public class CaesarCypherEncryptor {
    
    public static String caesarCypherEncryptor(String str, int key) {
        StringBuffer result = new StringBuffer();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        str.chars().forEach(character -> {
            int newPos = alphabet.indexOf(character) + key;
            if (newPos > alphabet.length() - 1) {
                result.append(alphabet.charAt(newPos % alphabet.length()));
            } else {
                result.append(alphabet.charAt(newPos));
            }
        });
        
        return result.toString();
      }

    public static void main(String[] args) {
        String input = "xyz";
        int key = 2;

        System.out.println(caesarCypherEncryptor(input, key));
    }
}
