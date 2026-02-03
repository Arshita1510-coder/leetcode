class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        int peak=n-1,valley=0;
        for(int i=0;i<n-1;i++){
            if(peak==n-1&&nums[i]>=nums[i+1]){
                peak=i;
            }
            if(valley==0&&nums[n-i-1]<=nums[n-i-2]){
                valley=n-i-1;
            }
            if(peak<valley){
                return isDecreasing(nums,peak,valley);

            }


        }
        return false;
    }
    public boolean isDecreasing(int[]A,int a,int b){
        if(a==0||b==A.length-1) return false;
        for(int i=a;i<b;i++){
            if(A[i]<=A[i+1]) return false;
        }
        return true;
    }
}