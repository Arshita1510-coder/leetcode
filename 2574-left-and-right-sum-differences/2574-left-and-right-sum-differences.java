class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int rightsum=0;
        for(int num:nums){
            rightsum+=num;
        }
        int leftsum=0;
        int[]result=new int[n];
        for(int i=0;i<n;i++){
            rightsum-=nums[i];
            result[i]=Math.abs(rightsum-leftsum);
            leftsum+=nums[i];
        }
        return result;

        
    }
}