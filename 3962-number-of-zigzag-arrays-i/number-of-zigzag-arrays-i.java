class Solution {
    public int zigZagArrays(int n, int l, int r) {
         long MOD=1000000007;
        int m = r - l + 1;
        long[] up = new long[m + 2];
        long[] down = new long[m + 2];
        for (int v = 1; v <= m; v++) {
            up[v] = v - 1;
            down[v] = m - v;
        }
        for (int len = 3; len <= n; len++) {
            long[] prefix = new long[m + 2];
            long[] suffix = new long[m + 3];

            for (int i = 1; i <= m; i++) {
                prefix[i] = (prefix[i - 1] + down[i]) % MOD;
            }

            for (int i = m; i >= 1; i--) {
                suffix[i] = (suffix[i + 1] + up[i]) % MOD;
            }

            long[] newUp = new long[m + 2];
            long[] newDown = new long[m + 2];
            for (int v = 1; v <= m; v++) {
                newUp[v] = prefix[v - 1];
                newDown[v] = suffix[v + 1];
            }

            up = newUp;
            down = newDown;
        }
        long ans = 0;
        if (n == 2) {
            for (int v = 1; v <= m; v++) {
                ans = (ans + up[v] + down[v]) % MOD;
            }
            return (int) ans;
        }
        for (int v = 1; v <= m; v++) {
            ans = (ans + up[v] + down[v]) % MOD;
        }

        return (int) ans;
    }
}