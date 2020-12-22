package io.programminglife.algoexpert.easy;

public class PalindromeCheck {
    
    public static boolean isPalindrome(String str) {
        int left = 0 , right = str.length() - 1;

        while(left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "abcxcsa";

        System.out.println(isPalindrome(input));
    }

}
