class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n=s.length();
        int q=queries.length;
        long MOD=1000000007;
        long[]preSum=new long[n+1];
        long[]pref=new long[n+1];
        int[]nonzerocount=new int[n+1];
        long[]pow=new long[n+1];
        pow[0]=1;
        for(int i=1;i<=n;i++){
            pow[i]=(pow[i-1]*10)%MOD;
        }
        for(int i=0;i<n;i++){
            int digit=s.charAt(i)-'0';
            preSum[i+1]=preSum[i]+digit;
            nonzerocount[i+1]=nonzerocount[i];

            if(digit!=0){
                nonzerocount[i+1]++;
                pref[i+1]=(pref[i]*10+digit)%MOD;
            }else{
                pref[i+1]=pref[i];
            }
        }
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            int digits = nonzerocount[right + 1] - nonzerocount[left];

            long value = (pref[right + 1]
                    - (pref[left] * pow[digits]) %MOD
                    + MOD) % MOD;

            long sum = preSum[right + 1] - preSum[left];

            ans[i] = (int) ((value * sum) % MOD);
        }

        return ans;
        
    }
}