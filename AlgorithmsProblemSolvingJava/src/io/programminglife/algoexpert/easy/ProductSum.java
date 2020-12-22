package io.programminglife.algoexpert.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductSum {

    public static int productSum(List<Object> array) {
        return sum(array, 1);
    }

    private static int sum(List<Object> array, int multiplier) {
        int pSum = 0;

        for (Object el : array) {
            if (el instanceof ArrayList) {
                @SuppressWarnings("unchecked")
                List<Object> embList = (ArrayList<Object>)el;
                pSum += sum(embList, multiplier + 1);
            } else {
                pSum += (int)el;
            }
        }

        return multiplier * pSum;
    }

    public static void main(String[] args) {
        List<Object> mainInput = new ArrayList<>();
        
        List<Object> sublist1 = new ArrayList<>();
        sublist1.add(7);
        sublist1.add(-1);
        
        List<Object> sublist2 = new ArrayList<>();
        
        List<Object> sublist3 = new ArrayList<>();
        sublist3.add(-13);
        sublist3.add(8);
        
        sublist2.add(6);
        sublist2.add(sublist3);
        
        mainInput.add(5);
        mainInput.add(2);
        mainInput.add(sublist1);
        mainInput.add(3);
        mainInput.add(sublist2);
        mainInput.add(4);

        System.out.println(productSum(mainInput));
    }
    
}
