package io.programminglife.leetcode.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays of equal length target and arr.
 * In one step, you can select any non-empty sub-array of arr and reverse it. You are allowed to make any number of steps.
 * Return True if you can make arr equal to target, or False otherwise.
 *
 * Example 1:
 *
 * Input: target = [1,2,3,4], arr = [2,4,1,3]
 * Output: true
 * Explanation: You can follow the next steps to convert arr to target:
 * 1- Reverse sub-array [2,4,1], arr becomes [1,4,2,3]
 * 2- Reverse sub-array [4,2], arr becomes [1,2,4,3]
 * 3- Reverse sub-array [4,3], arr becomes [1,2,3,4]
 * There are multiple ways to convert arr to target, this is not the only way to do so.
 */
public class MakeTwoArraysEqual {

    public static boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> storage = new HashMap<>();

        for(int i : target) {
            storage.put(i, storage.getOrDefault(i, 0) + 1);
        }

        for(int i : arr) {
            storage.put(i, storage.getOrDefault(i, 0) - 1);
        }

        for(int key : storage.keySet()) {
            if(storage.get(key) != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] target = {3,7,9};
        int[] arr = {3,7,11};

        System.out.println(canBeEqual(target, arr));
    }

}
