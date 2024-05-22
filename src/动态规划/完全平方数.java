package 动态规划;

import java.util.Arrays;

public class 完全平方数 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 0可以由0个平方数组成

        for (int i = 1; i <= n; i++) {
            // 遍历所有可能的平方数来更新dp[i]
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

/*
遍历所有j导致超时
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            if (Math.sqrt(i) % 1 == 0){
                dp[i] = 1;
                continue;
            }
            for (int j = i-1; j >= 0 ; j--) {
                if(Math.sqrt(j) % 1 == 0)
                    dp[i] = Math.min(dp[i], dp[i-j] + 1);
            }
        }
        return dp[n];
    }
    }*/
}
