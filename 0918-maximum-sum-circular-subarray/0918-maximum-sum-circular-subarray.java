class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int maxEnd=nums[0];
        int minEnd=nums[0];
        int maxSum=nums[0];
        int minSum=nums[0];
        int total=nums[0];
        for(int i=1;i<n;i++){
            total+=nums[i];
            int v1=nums[i];
            int v2=maxEnd+nums[i];
            int v3=nums[i];
            int v4=minEnd+nums[i];
            maxEnd=Math.max(v1,v2);
            minEnd=Math.min(v3,v4);
            maxSum=Math.max(maxEnd,maxSum);
            minSum=Math.min(minEnd,minSum);
            
            
        }
        if(maxSum<0){
                return maxSum;
        }
        return Math.max(maxSum,total-minSum);
        
        
    }
}