class Solution {
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[]dp=new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int maxi=Integer.MIN_VALUE;
            int len=0;
            int maxAns=0;
            for(int j=i;j<Math.min(n,i+k);j++){
              len++;
              maxi=Math.max(maxi,arr[j]);
              int Sum=(len*maxi)+dp[j+1];
              maxAns=Math.max(maxAns,Sum);
            }
            dp[i]=maxAns;
        }
        return dp[0];
        
        
        
    }
}