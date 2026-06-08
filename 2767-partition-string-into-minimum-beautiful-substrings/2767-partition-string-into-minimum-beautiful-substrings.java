import java.util.*;

class Solution {

    public int minimumBeautifulSubstrings(String s) {
        int n = s.length();

        // Store all powers of 5 that can appear in a binary string of length <= 15
        HashSet<Long> powers = new HashSet<>();
        long num = 1;

        while (num <= 32767) { // 2^15 - 1
            powers.add(num);
            num *= 5;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int ans = solve(0, s, dp, powers);

        return ans >= (int)1e9 ? -1 : ans;
    }

    private int solve(int i, String s, int[] dp, HashSet<Long> powers) {
        int n = s.length();

        if (i == n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        if (s.charAt(i) == '0') {
            return dp[i] = (int)1e9;
        }

        long num = 0;
        int ans = (int)1e9;

        for (int j = i; j < n; j++) {
            num = num * 2 + (s.charAt(j) - '0');

            if (powers.contains(num)) {
                int next = solve(j + 1, s, dp, powers);

                if (next != (int)1e9) {
                    ans = Math.min(ans, 1 + next);
                }
            }
        }

        return dp[i] = ans;
    }
}