package leetcode_75;

import java.util.HashMap;
import java.util.HashSet;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int need = k - nums[i];
            if (map.contains(need)){
                count++;
                map.remove(need);
            }
            else {
                map.add(nums[i]);
            }
        }
        return count;
    }
}
