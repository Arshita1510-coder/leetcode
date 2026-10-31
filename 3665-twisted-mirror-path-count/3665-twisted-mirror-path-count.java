
import java.util.*;

class Solution {

    int m, n;
    int[][][] memo;

    int MOD = 1000000007;

   

    int resolve(int r, int c, int dir, int[][] grid) {

        if (r >= m || c >= n) {
            return -1;
        }

       
        if (grid[r][c] == 0) {
            return r * n + c;
        }

       
        if (memo[r][c][dir] != -2) {
            return memo[r][c][dir];
        }

        int ans;

        if (dir == 0) {
           
            ans = resolve(r + 1, c, 1, grid);
        } else {
            
            ans = resolve(r, c + 1, 0, grid);
        }

        memo[r][c][dir] = ans;

        return ans;
    }

    public int uniquePaths(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        memo = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -2);
            }
        }

        long[][] dp = new long[m][n];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (dp[i][j] == 0) {
                    continue;
                }

                
                int right = resolve(i, j + 1, 0, grid);

                if (right != -1) {
                    int x = right / n;
                    int y = right % n;

                    dp[x][y] = (dp[x][y] + dp[i][j]) % MOD;
                }

               
                int down = resolve(i + 1, j, 1, grid);

                if (down != -1) {
                    int x = down / n;
                    int y = down % n;

                    dp[x][y] = (dp[x][y] + dp[i][j]) % MOD;
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }
}
