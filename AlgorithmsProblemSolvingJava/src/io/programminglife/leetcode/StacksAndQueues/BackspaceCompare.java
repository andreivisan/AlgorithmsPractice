package io.programminglife.leetcode.StacksAndQueues;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 *
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 *
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 */
public class BackspaceCompare {

    public static boolean backspaceCompare(String S, String T) {
        return formatString(S).equals(formatString(T));
    }

    static String formatString(String input) {
        StringBuffer buffer = new StringBuffer();
        Stack<Character> storage = new Stack<>();

        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '#' && !storage.isEmpty()) {
                storage.pop();
            }
            if(input.charAt(i) != '#') {
                storage.push(input.charAt(i));
            }
        }

        while(!storage.isEmpty()) {
            buffer.append(storage.pop());
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        String S = "a#c";
        String T = "b";

        System.out.println(backspaceCompare(S, T));
    }

}
