class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left=0;
        long sum=0;
        long maxSum=Integer.MIN_VALUE;
        
        int n=nums.length;
        for(int right=0;right<n;right++){
            sum+=nums[right];
            while(right-left+1>k){
                sum-=nums[left];
                left++;

            }
            if(right-left+1==k){
                maxSum=Math.max(maxSum,sum);
            }


        }
        return (double)maxSum/k;
        
        
        
    }
}