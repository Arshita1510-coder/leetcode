class Solution {
    public static int f(int ind,int n,int arr[],int k,int[]dp){
        if(ind==n) return 0;
        int maxAns=0;
        int len=0;
        int maxi=Integer.MIN_VALUE;
        if(dp[ind]!=-1) return dp[ind];
        for(int j=ind;j<Math.min(n,ind+k);j++){
            len++;
            maxi=Math.max(maxi,arr[j]);
            int Sum=(len*maxi)+f(j+1,n,arr,k,dp);
            maxAns=Math.max(maxAns,Sum);
        }
        return dp[ind]= maxAns;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[]dp=new int[n];
        Arrays.fill(dp,-1);
        return f(0,n,arr,k,dp);
        
    }
}