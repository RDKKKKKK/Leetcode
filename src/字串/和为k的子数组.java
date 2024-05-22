package 字串;

public class 和为k的子数组 {
    public int subarraySum(int[] nums, int k) {
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
