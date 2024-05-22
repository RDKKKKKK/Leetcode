package 哈希表;

import java.util.HashMap;

public class 存在重复元素 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - k; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                if (! map.containsValue(nums[j])){
                    map.put(j, nums[j]);
                }
                else
                    return true;
            }
        }
        return false;
    }
}
