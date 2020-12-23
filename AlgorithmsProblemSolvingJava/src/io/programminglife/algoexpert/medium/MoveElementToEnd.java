package io.programminglife.algoexpert.medium;

import java.util.List;

public class MoveElementToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int left = 0, right = array.size() - 1;

        while (left < right) {
            if (array.get(left) == toMove && array.get(right) != toMove) {
                int temp = array.get(left);
                array.set(left,array.get(right));
                array.set(right, temp);
                left++;
                right--;
            } else if (array.get(right) == toMove) {
                right--;
            } else if (array.get(left) != toMove) {
                left++;
            }
        }
        
        return array;
    }
}
