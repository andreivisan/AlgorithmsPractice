package io.programminglife.leetcode.Arrays;


//Same as TwoSum only that the array is sorted in ascending order
public class TwoSum2 {

    public static int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        int[] result = {-1, -1};

        while(low < high) {
            int sum = numbers[low] + numbers[high];

            if(sum == target) {
                result[0] = low + 1;
                result[1] = high + 1;
                return result;
            } 
            
            if(sum < target) {
                low++;
            } 

            if(sum > target) {
                high--;
            }
        }

        return result;
    }
    
}
