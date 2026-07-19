class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int zeros=0;
        int maxLen=0;
        for(int right=0;right<n;right++){
            if(nums[right]==0) zeros++;
            if(zeros>k){
                if(nums[left]==0) zeros--;
                left++;
            }
            maxLen=Math.max(maxLen,(right-left+1));

        }
        return maxLen;
        
    }
}