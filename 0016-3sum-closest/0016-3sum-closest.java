class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int result=0;
        int diff=Integer.MAX_VALUE;
        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;
            
            while(left<right){
               int Sum=nums[i]+nums[left]+nums[right];
               int d=Math.abs(target-Sum);
               if(diff>d){
                 diff=d;
                 result=Sum;
               }
               if(Sum==target){
                return result;
               }else if(Sum<target){
                left++;
               }else{
                right--;
               }
            }
            
        }
        return result;
        
    }
}