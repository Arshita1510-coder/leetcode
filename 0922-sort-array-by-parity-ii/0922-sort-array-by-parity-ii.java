class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n=nums.length;

        int ans[]=new int[n];
        int evenindex=0;
        int oddindex=1;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                ans[evenindex]=nums[i];
                evenindex+=2;
            }else{
                ans[oddindex]=nums[i];
                oddindex+=2;
            }
        }
        return ans;
        
    }
}