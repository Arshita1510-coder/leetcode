class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low=0;
        int high=0;
        int result=Integer.MAX_VALUE;
        int Sum=0;
        int n=nums.length;
        while(high<n){
            Sum=Sum+nums[high];
            while(Sum>=target){
                int len=high-low+1;
                result=Math.min(result,len);
                Sum=Sum-nums[low];
                low++;
            }
            high++;
        }
       return result==Integer.MAX_VALUE?0:result;
    }
}