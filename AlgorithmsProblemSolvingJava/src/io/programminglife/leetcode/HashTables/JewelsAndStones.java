package io.programminglife.leetcode.HashTables;

import java.util.HashMap;
import java.util.Map;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 *
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 */
public class JewelsAndStones {

    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        Map<Character, Integer> countMap = new HashMap<>();

        for(int i = 0; i < S.length(); i++) {
            if(countMap.get(S.charAt(i)) != null) {
                countMap.put(S.charAt(i), countMap.get(S.charAt(i)) + 1);
            } else {
                countMap.put(S.charAt(i), 1);
            }
        }

        for(int i = 0; i < J.length(); i++) {
            if(countMap.get(J.charAt(i)) != null) {
                count += countMap.get(J.charAt(i));
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("z", "ZZ"));
    }

}
