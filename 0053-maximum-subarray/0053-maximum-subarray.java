class Solution {
    public int maxSubArray(int[] nums) {
        long maxi=Long.MIN_VALUE;
        long Sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            Sum+=nums[i];
            if(Sum>maxi){
                maxi=Sum;
            }
            


            if(Sum<0){
                Sum=0;

            }
        }
        return (int)maxi;
        
    }
}