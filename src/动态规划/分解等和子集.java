package 动态规划;

public class 分解等和子集 {

    /**
     * 动态规划：0-1 背包问题
     * 注意状态的设计： 前缀和思想
     */

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        if (n < 2) {
            return false;
        }

        //计算target值，等和则target即为总和一半
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }

        //总和奇数不可能一半
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        //减少计算 & 也是防止dp数组越界  boolean[][] dp = new boolean[n][target + 1]; < maxNum
        if (maxNum > target) {
            return false;
        }

        /**
         * 状态：
         *      dp[i][j] 表示 nums[0-i] 区间内是否存在和为j的组合
         * 转移方程：
         *      1. j > nums[i]：加入当前值也不够，只能依靠之前的 dp[i][j] = dp[i - 1][j]
         *      2. j <= nums[i]：可以选择是否加入当前值：dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num]
         */

        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }
}
