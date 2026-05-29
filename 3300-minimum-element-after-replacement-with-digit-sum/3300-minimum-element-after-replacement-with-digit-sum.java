class Solution {
    public int minElement(int[] nums) {
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int num=nums[i];
            int Sum=0;
            while(num>0){
                Sum+=num%10;
                num/=10;
            }
            if(Sum<ans) ans=Sum;
        }
        return ans;
        
    }
}