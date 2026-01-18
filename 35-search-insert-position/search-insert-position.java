class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        
        int left=0;
        int high=n-1;
        int ans=n;
        while(left<=high){
            int mid=(left+high)/2;
            if(nums[mid]>=target){
                ans=mid;
                high=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
        
    }
}