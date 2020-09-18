package io.programminglife.leetcode.StacksAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 * Input: s = "([)]"
 * Output: false
 *
 * Example 5:
 * Input: s = "{[]}"
 * Output: true
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }

        Map<Character, Character> paranthesesMap = new HashMap<>();
        paranthesesMap.put(')', '(');
        paranthesesMap.put(']', '[');
        paranthesesMap.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && paranthesesMap.get(s.charAt(i)) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
         }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[]}";

        System.out.println(isValid(s));
    }

}
