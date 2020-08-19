package io.programminglife.leetcode.HashTables;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode"
 * return 2.
 */
public class FirstUniqueCharacterInString {

    public static int firstUniqChar(String s) {
        int position = -1;
        Map<Character, Boolean> dict = new HashMap<>();

        for(int i=0; i < s.length(); i++) {
            dict.put(s.charAt(i), dict.get(s.charAt(i)) == null);
        }

        for(int i=0; i < s.length(); i++) {
            if(dict.get(s.charAt(i))) {
                return i;
            }
        }

        return position;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

}
