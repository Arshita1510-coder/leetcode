class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max=nums[0];
        int min=nums[0];
        int n=nums.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        return (long)(max-min)*k;
        
    }
}