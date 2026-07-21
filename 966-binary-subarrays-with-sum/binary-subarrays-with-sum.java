class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(goal==0){
            int ans=0;
            int zeros=0;
            for(int x:nums){
                if(x==0){
                    zeros++;
                }else{
                    ans+=zeros*(zeros+1)/2;
                    zeros=0;
                }
            }
            ans+=zeros*(zeros+1)/2;
            return ans;

        }
        int left=0;
        int sum=0;
        int count=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>goal){
                sum-=nums[left];
                left++;
            }
            if(sum==goal){
                count++;
                int temp=left;
                while(temp<right&&nums[temp]==0){
                    temp++;
                    count++;
                }
            }

        }
        return count;
        
    }
}