class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;      // rows
        int n = obstacleGrid[0].length;   // cols

        // Edge case: starting cell blocked
        if (obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[m][n];

        // Starting point
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // If obstacle → no paths
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                // Skip start cell (already set)
                if (i == 0 && j == 0) continue;

                int up = 0, left = 0;

                if (i > 0) up = dp[i - 1][j];
                if (j > 0) left = dp[i][j - 1];

                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }
}