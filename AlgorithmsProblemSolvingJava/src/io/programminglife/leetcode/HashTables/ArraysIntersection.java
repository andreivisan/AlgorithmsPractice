package io.programminglife.leetcode.HashTables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order,
 * return a sorted array of only the integers that appeared in all three arrays.
 *
 * Example 1:
 *
 * Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * Output: [1,5]
 * Explanation: Only 1 and 5 appeared in the three arrays.
 */
public class ArraysIntersection {

    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> intersectionList = new ArrayList<>();
        Map<Integer, Integer> storage = new HashMap<>();

        for(int i = 0; i < arr1.length; i++) {
            storage.put(arr1[i], 1);
        }

        for(int i = 0; i < arr2.length; i++) {
            if(storage.get(arr2[i]) != null) {
                storage.put(arr2[i], 2);
            }
        }

        for(int i = 0; i < arr3.length; i++) {
            if(storage.get(arr3[i]) != null && storage.get(arr3[i]) ==2) {
                intersectionList.add(arr3[i]);
            }
        }

        return intersectionList;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,5,7,9};
        int[] arr3 = {1,3,4,5,8};

        List<Integer> intersectionList = arraysIntersection(arr1, arr2, arr3);

        for(int element: intersectionList) {
            System.out.println(element);
        }
    }

}
