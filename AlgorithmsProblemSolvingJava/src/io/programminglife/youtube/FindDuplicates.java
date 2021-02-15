package io.programminglife.youtube;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int pos = Math.abs(nums[i]) - 1;
            if (nums[pos] < 0) {
                return Math.abs(nums[i]);
            }
            nums[pos] *= -1;
        }

        return -1;
    }

    public int findDuplicateSet(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }

}
