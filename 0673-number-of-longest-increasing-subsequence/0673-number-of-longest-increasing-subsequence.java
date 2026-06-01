class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[]dp=new int[n];
        Arrays.fill(dp,1);
        int[]Cnt=new int[n];
        Arrays.fill(Cnt,1);
        int maxi=1;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[prev]<nums[i]&&dp[prev]+1>dp[i]){
                    dp[i]=1+dp[prev];
                    Cnt[i]=Cnt[prev];
                }else if(nums[prev]<nums[i]&&dp[prev]+1==dp[i]){
                    Cnt[i]+=Cnt[prev];
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        int CountLIS=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxi){
                CountLIS+=Cnt[i];
            }
        }
        return CountLIS;

        
    }
}