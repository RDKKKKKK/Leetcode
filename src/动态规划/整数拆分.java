package 动态规划;

public class 整数拆分 {
    /**
     * 状态转移方程要能覆盖所有情况，拆分情况 = 乘拆分的数本身/拆分的数的最大乘积
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        //dp[n]: the max product of integers that complement n
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 1; i <= n ; i++) {
            int max = 0;
            for (int j = 1; j < n; j++) {
                if (dp[i-j]*j > max) max = dp[i-j]*j;
                if ((i-j)*j > max) max = (i-j)*j;
            }
            dp[i] = max;
        }

        return dp[n];
    }
}
