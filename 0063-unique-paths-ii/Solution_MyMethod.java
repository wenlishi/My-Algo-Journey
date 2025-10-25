public class Solution_MyMethod {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 && i == 0 && obstacleGrid[i][j] == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (i == 0 && j > 0 && obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                if (j == 0 && i > 0 && obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i > 0 && j > 0 && obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
                
            }
        }
        return dp[m - 1][n - 1];
        
    }
}
