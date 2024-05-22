package 动态规划;

public class 爬楼梯 {


    /**
     * 动态规划 轮转数组
     */
    public int climbStairs(int n){
        int p=0, q=1, r=2;
        for (int i = 3; i <=n; i++) {
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }

    /**
     * 动态规划 dp方程

    public int climbStairs(int n){
        int[] dp = new int[100];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 递归实现 - 超时
     * @param n
     * @return

    public int climbStairs(int n) {
        if (n==0)
            return 0;
        else if (n==1)
            return 1;
        else
            return  climbStairs(n-1) + climbStairs(n-2);
    }

     */
}
