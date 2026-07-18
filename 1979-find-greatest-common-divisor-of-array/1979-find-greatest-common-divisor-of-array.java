class Solution {
    public int findGCD(int[] nums) {
        int max1=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<max1){
                max1=nums[i];

            }
        }
        int max2=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max2){
                max2=nums[i];
            }
        }
        while(max2!=0){
            int temp=max2;
            max2=max1%max2;
            max1=temp;
        }
        return max1;
        
    }
}