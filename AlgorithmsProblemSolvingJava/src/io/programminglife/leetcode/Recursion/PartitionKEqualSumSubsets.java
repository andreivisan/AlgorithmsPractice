package io.programminglife.leetcode.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PartitionKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = sum(nums);

        if (sum%k != 0) {
            return false;
        }

        List<List<Integer>> partitions = new ArrayList<>();
        int targetValue = sum/k;
        int[] target = new int[k];
        for (int i = 0; i < k; i++) {
            target[i] = targetValue;
            partitions.add(new ArrayList<>());
        }
        
        return partition(nums, 0, target, partitions);
    }

    private boolean partition(int[] nums, int i, int[] target, List<List<Integer>> partitions) {
        for (int j = 0; j < target.length && i < nums.length; j++) {
            int currentValue = nums[i];
            if (target[j] >= currentValue) {
                target[j] -= currentValue;

                if (partition(nums, i + 1, target, partitions)) {
                    partitions.get(j).add(currentValue);
                    break;
                } else {
                    target[j] += currentValue;
                }
            }
        }
        
        return sum(target) == 0;
    }

    private int sum(int[] input) {
        int sum = 0;

        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;

        System.out.println(new PartitionKEqualSumSubsets().canPartitionKSubsets(nums, k));
    }
    
}
