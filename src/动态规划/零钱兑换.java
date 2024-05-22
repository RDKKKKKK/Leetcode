package 动态规划;

import java.util.Arrays;

public class 零钱兑换 {

    /**
     * coins并未排序
     * @param coins
     * @param amount
     * @return
     */



    public int coinChange(int[] coins, int amount) {
        int max = amount + 1; // 用来表示无效解
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max); // 初始化为最大值
        dp[0] = 0; // 凑成金额为0需要0个硬币

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }



    /*
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[13];

        if (coins[0] > amount)
            return  -1;

        for (int i = 0; i < coins[0]; i++) {
            dp[i] = -1;
        }

        for (int i = coins[0]; i <= amount; i++) {
            dp[i] = -1;
            for (int j = coins.length - 1; j>=0; j--){
                if (i-coins[j]>=0 && dp[i-coins[j]] != -1)
                    dp[i] = dp[amount-coins[j]] + 1;
            }
        }

        return dp[amount];
    }*/
}
