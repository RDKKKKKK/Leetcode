package 动态规划;

public class 不同路径 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        /**
         * 起点和终点有障碍直接返回0
         * 第0行/列初始化时遇到障碍，后续全部为0
         */

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m+1][n+1];

        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1)
            return 0;

        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) dp[i][0] = 1;
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) dp[0][j] = 1;

        for (int i = 1;i < m;i++){
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                System.out.println(i + " "+ j + " " + dp[i][j]);

            }
        }

        return dp[m-1][n-1];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1;i<m;i++){
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
