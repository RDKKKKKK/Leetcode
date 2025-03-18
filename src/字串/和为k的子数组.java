package 字串;

import java.util.HashMap;

/**
 *  前缀和 + 哈希表
 *  define pre[i] to be the sum from 0 to i
 *      pre[i] = pre[i-1] + nums[i]
 *  then any sub-array from j to i : pre[i] - pre[j-1] = k
 *  then pre[j-1] = pre[i] - k
 *  that is, find for any i, how many j satisfy this condition
 *  use HashMap to count numbers for each pre value
 */

public class 和为k的子数组 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums.length == 0) return 0;
        int pre = 0;
        int count = 0;
        map.put(0,1); // !!!需要设置，数学推导才生效，不然漏情况
        for (int i = 0; i < nums.length; i++) {
            pre+=nums[i];

            //先判断再放入当前元素前缀和，否则读到"当前和"而非前缀和
            if (map.containsKey(pre - k))
                count+=map.get(pre - k);

            map.put(pre, map.getOrDefault(pre, 0)+1);
        }
        return count;
    }



        public int subarraySum1(int[] nums, int k) {
        int start = 0, end = 0, count = 0;
        while (start < nums.length && end < nums.length){
            int cur = nums[start];
            for (int i = start + 1; i <= end; i++) {
                cur += nums[i];
            }
            if (cur < k && nums[start] > 0)
                end++;
            else if (cur < k && nums[start] < 0)
                start++;
            else if (cur > k && nums[start] > 0)
                start++;
            else if (cur > k && nums[start] < 0)
                end++;
            else if (cur == k){
                count++;
                start++;
                end++;
            }

            if (start>=end) end++;
        }

        return count;
    }
}
