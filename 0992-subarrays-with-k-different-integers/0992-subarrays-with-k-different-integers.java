class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    public int atMost(int[]nums,int k){
        int left=0;
        int Count=0;
        int n=nums.length;
        HashMap<Integer,Integer>freq=new HashMap<>();
        for(int right=0;right<n;right++){
            freq.put(nums[right],freq.getOrDefault(nums[right],0)+1);
            if(freq.get(nums[right])==1) {
                k--;
            }

            while(k<0){
                freq.put(nums[left],freq.get(nums[left])-1);
                
                if(freq.get(nums[left])==0){
                    k++;
                }
                left++;
            }
            Count+=(right-left+1);

        }
        return Count;
        
    }
}