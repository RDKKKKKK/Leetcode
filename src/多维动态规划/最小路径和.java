package 多维动态规划;

public class 最小路径和 {

    /*  FOR循环可以合并到一起
        public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp= new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0;j < n; j++) {
                if (i == 0) dp[i+1][j+1] = dp[i+1][j] + grid[i][j];
                else if (j == 0) dp[i+1][j+1] = dp[i][j+1] + grid[i][j];
                else dp[i+1][j+1] = Math.min(dp[i][j+1], dp[i+1][j]) + grid[i][j];
            }
        }
        return dp[m][n];

     */

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[200][200];
        int m = grid.length;
        int n = grid[0].length;

        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] += dp[i-1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] += dp[0][j-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}
