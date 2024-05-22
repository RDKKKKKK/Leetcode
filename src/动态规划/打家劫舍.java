package 动态规划;

import java.util.HashMap;
import java.util.Map;

public class 打家劫舍 {
    public int rob(int[] nums) {
        int[] dp = new int[101];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int totalMax = 0;
        for (int i = 2; i < nums.length; i++) {
            int max = 0, pos = 0;
            for (int j = i; j >= 0; j-=2) {
                if (dp[j] > max){
                    max = dp[j];
                    pos = j;
                }
            }
            dp[i] += dp[pos];
            if (dp[i] > totalMax)
                totalMax = dp[i];
        }
        return totalMax;
    }
}
