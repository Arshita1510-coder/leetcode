class Solution {
    public int minStartValue(int[] nums) {
        int n=nums.length;
        int preSum=0;
        int min=0;
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            min=Math.min(preSum,min);
        }
        return 1-min;
        
    }
}