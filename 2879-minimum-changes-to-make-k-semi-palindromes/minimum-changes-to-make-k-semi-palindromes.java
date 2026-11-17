
class Solution {

    public int minimumChanges(String s, int k) {

        int n = s.length();

        // cost[i][j] = minimum changes to make s[i...j]
        // a semi-palindrome
        int[][] cost = new int[n][n];

        // Precompute semi-palindrome costs
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len <= n; i++) {

                int j = i + len - 1;
                cost[i][j] = Integer.MAX_VALUE;

                // Try every valid divisor d
                for (int d = 1; d < len; d++) {

                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    // Check all d groups
                    for (int start = 0; start < d; start++) {

                        int left = start;
                        int right = len - d + start;

                        while (left < right) {

                            if (s.charAt(i + left) != s.charAt(i + right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    cost[i][j] = Math.min(cost[i][j], changes);
                }
            }
        }

        // DP
        int INF = 1000000;
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = INF;
            }
        }

        dp[0][0] = 0;

        // i = number of substrings
        for (int i = 1; i <= k; i++) {

            // j = number of characters considered
            for (int j = 2 * i; j <= n; j++) {

                // Last substring is s[p...j-1]
                for (int p = 2 * (i - 1); p <= j - 2; p++) {

                    if (dp[i - 1][p] == INF) {
                        continue;
                    }

                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - 1][p] + cost[p][j - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
