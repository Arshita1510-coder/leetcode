class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        int prev2=0;
        int prev1=nums[0];
        for(int i=1;i<nums.length;i++){
            int take=nums[i]+prev2;
            int nontake=prev1;
            int curr=Math.max(take,nontake);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    
}