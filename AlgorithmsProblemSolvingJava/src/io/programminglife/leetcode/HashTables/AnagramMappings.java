package io.programminglife.leetcode.HashTables;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.
 * These lists A and B may contain duplicates. If there are multiple answers, output any of them.
 *
 * For example, given
 *
 * A = [12, 28, 46, 32, 50]
 * B = [50, 12, 32, 46, 28]
 *
 * We should return
 * [1, 4, 3, 2, 0]
 */
public class AnagramMappings {

    public static int[] anagramMappings(int[] A, int[] B) {
        int[] mappings = new int[A.length];
        Map<Integer, Integer> positionsMap = new HashMap<>();

        for(int i = 0; i < B.length; i++) {
            positionsMap.put(B[i], i);
        }

        for(int i = 0; i < A.length; i++) {
            mappings[i] = positionsMap.get(A[i]);
        }

        return mappings;
    }

    public static void main(String[] args) {
        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};

        int[] mappings = anagramMappings(A, B);

        for(int i = 0; i < mappings.length; i++) {
            System.out.println(mappings[i]);
        }
    }

}


