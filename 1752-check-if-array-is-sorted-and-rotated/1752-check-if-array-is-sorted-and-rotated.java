class Solution {
    public boolean check(int[] nums) {
        int Count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n]){
                Count++;
            }
        }
        return Count<=1;
        
    }
}