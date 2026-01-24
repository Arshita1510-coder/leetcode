class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        int max=0;
        while(left<right){
            int Sum=nums[left]+nums[right];
            if(Sum>max){
               max=Sum;
            }
            left++;
            right--;

        }
        return max;

        
    }
}