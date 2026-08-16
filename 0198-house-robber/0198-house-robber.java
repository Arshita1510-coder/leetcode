class Solution {
   
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        int prev2=0;
        int prev1=nums[0];
        for(int i=1;i<nums.length;i++){
            int take=nums[i];
            if(i>1) take+=prev2;
            int notTake=prev1;
            int curri=Math.max(take,notTake);
            prev2=prev1;
            prev1=curri;
        }
        return prev1;
    }
}