class Solution {
    public static int getAns(int[]arr,int d,int n,int i,int[]dp){
        if(dp[i]!=-1) return dp[i];
        int ans=1;
        for(int j=i-1;j>=Math.max(0,i-d);j--){
            if(arr[j]>=arr[i]){
                break;
            }else{
                ans=Math.max(ans,1+getAns(arr,d,n,j,dp));
            }
        }
        for(int j=i+1;j<=Math.min(n-1,i+d);j++){
            if(arr[j]>=arr[i]){
                break;
            }else{
                ans=Math.max(ans,1+getAns(arr,d,n,j,dp));
            }
        }
        return dp[i]=ans;

    }
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        int ans=1;
        int[]dp=new int[n];
         Arrays.fill(dp,-1);
        
       for(int i=0;i<n;i++){
        ans=Math.max(ans,getAns(arr,d,n,i,dp));
       }
       return ans;
        
    }
}