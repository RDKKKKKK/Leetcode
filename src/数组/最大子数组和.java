package 数组;

public class 最大子数组和 {
    /**
     * DP数组可以省略，不需要之前所有的值
     * @param nums
     * @return
     */

    public int maxSubArray1(int[] nums) {

        int cur = 0;
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(cur+nums[i], nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }

    /**            IF比大小可以简写：
     *
     *             pre = Math.max(pre + x, x);
     *             maxAns = Math.max(maxAns, pre);
     *
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[100000];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
