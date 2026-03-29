class Solution {
     public boolean subsetSumToK(int ind, int target, int[] nums,int[][]dp) {
        if(target==0) return true;
        if(ind==0) return (nums[0]==target);
        if(dp[ind][target]!=-1) return dp[ind][target]==1;
        boolean notTake=subsetSumToK(ind-1,target,nums,dp);
        boolean take=false;
        if(nums[ind]<=target){
            take=subsetSumToK(ind-1,target-nums[ind],nums,dp);
        }
        dp[ind][target]=(notTake||take)?1:0;
        return notTake||take;
     }

    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalSum=0;
        for(int i=0;i<n;i++) totalSum+=nums[i];
        if(totalSum%2==1) return false;
        int target=totalSum/2;
        int[][]dp=new int[n][target+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return subsetSumToK(n-1,target,nums,dp);

        
    }
}