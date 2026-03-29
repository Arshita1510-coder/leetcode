class Solution {
     

    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalSum=0;
        for(int i=0;i<n;i++) totalSum+=nums[i];
        if(totalSum%2==1) return false;
        int target=totalSum/2;
        boolean[][]dp=new boolean[n][target+1];
        for(int i=0;i<n;i++) dp[i][0]=true;
        if(nums[0]<=target) dp[0][nums[0]]=true;
        for(int ind=1;ind<n;ind++){
            for(int tar=1;tar<=target;tar++){
                boolean nottake=dp[ind-1][tar];
                boolean take=false;
                if(nums[ind]<=tar){
                    take=dp[ind-1][tar-nums[ind]];

                }
                dp[ind][tar]=nottake||take;
            }
        }
        return dp[n-1][target];

        
    }
}