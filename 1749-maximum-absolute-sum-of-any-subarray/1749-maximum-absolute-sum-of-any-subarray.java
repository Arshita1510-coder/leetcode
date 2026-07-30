class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n=nums.length;
        int maxEnd=nums[0];
        int minEnd=nums[0];
        int maxSum=nums[0];
        int minSum=nums[0];
        for(int i=1;i<n;i++){
            int v1=nums[i];
            int v2=maxEnd+nums[i];
            int v3=nums[i];
            int v4=minEnd+nums[i];
            maxEnd=Math.max(v1,v2);
            minEnd=Math.min(v3,v4);
            maxSum=Math.max(maxSum,maxEnd);
            minSum=Math.min(minSum,minEnd);
        }
        return Math.max(maxSum,-minSum);
        
    }
}