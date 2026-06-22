class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxi=0;
        int Count=0;
        for(int i=0;i<nums.length;i++){

          if(nums[i]==1){
            Count++;
            maxi=Math.max(maxi,Count);
          }else{
            Count=0;
          }
        }
        return maxi;
        
    }
}