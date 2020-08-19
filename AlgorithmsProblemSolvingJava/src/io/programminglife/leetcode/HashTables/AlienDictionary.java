package io.programminglife.leetcode.HashTables;

import java.util.HashMap;
import java.util.Map;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 * Given a sequence of words written in the alien language, and the order of the alphabet,
 * return true if and only if the given words are sorted lexicographicaly in this alien language.
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.)
 * According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character
 * which is less than any other character.
 */
public class AlienDictionary {

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> dict = new HashMap<>();

        for(int i = 0; i < order.length(); i++) {
            dict.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length - 1; i++) {
            int k = 0;
            while(k < words[i].length() && k < words[i + 1].length()) {
                if(dict.get(words[i].charAt(k)) > dict.get(words[i + 1].charAt(k))) {
                    return false;
                } else if(dict.get(words[i].charAt(k)) == dict.get(words[i + 1].charAt(k))){
                    k++;
                } else {
                    break;
                }
                if(k == words[i + 1].length() && k < words[i].length()) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(isAlienSorted(words, order));
    }

}
