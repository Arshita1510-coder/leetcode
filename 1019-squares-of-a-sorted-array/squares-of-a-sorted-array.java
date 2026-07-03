class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[]result=new int[n];
       int left=0;
       int right=n-1;
       int p=n-1;
       while(left<=right){
        int l=nums[left]*nums[left];
        int r=nums[right]*nums[right];
        if(l>r){
            result[p]=l;
            left++;
        }else{
            result[p]=r;
            right--;
        }
        p--;
       }
       return result;
        
    }
}