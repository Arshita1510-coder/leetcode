class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return solve(nums,n-1,dp);
        
    }
    public int solve(int nums[],int i,int[]dp){
        if(i==0) return nums[0];
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick=nums[i]+solve(nums,i-2,dp);
        int notPick=solve(nums,i-1,dp);
        return dp[i]=Math.max(pick,notPick);
    }
}