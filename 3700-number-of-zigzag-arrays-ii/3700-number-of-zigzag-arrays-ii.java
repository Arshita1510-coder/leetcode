class Solution {
    private static final long MOD = 1000000007L;
    
    public int zigZagArrays(int n, int l, int r) {
       
        int m = r - l + 1;
        int size = 2 * m;
         long[] state = new long[size];

        for (int x = 0; x < m; x++) {
            state[x] = x;                 
            state[m + x] = m - x - 1;    
        }

        if (n == 2) {
            long ans = 0;
            for (long v : state) ans = (ans + v) % MOD;
            return (int) ans;
        }

        long[][] T = new long[size][size];

        
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < x; y++) {
                T[x][m + y] = 1;
            }
        }

        
        for (int x = 0; x < m; x++) {
            for (int y = x + 1; y < m; y++) {
                T[m + x][y] = 1;
            }
        }

        long[][] power = matrixPower(T, n - 2);

        long[] result = multiply(power, state);

        long ans = 0;
        for (long v : result) {
            ans = (ans + v) % MOD;
        }

        return (int) ans;
    }

    private long[][] matrixPower(long[][] mat, long exp) {
        int n = mat.length;

        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiply(result, mat);
            }

            mat = multiply(mat, mat);
            exp >>= 1;
        }

        return result;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;

                long aik = A[i][k];

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;

                    res[i][j] = (res[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }

        return res;
    }

    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;

            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) continue;

                sum = (sum + A[i][j] * v[j]) % MOD;
            }

            res[i] = sum;
        }

        return res;
    }
}