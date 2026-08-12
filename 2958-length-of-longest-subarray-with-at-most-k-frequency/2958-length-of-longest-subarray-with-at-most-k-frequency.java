class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int low=0;
        int n=nums.length;
        int maxLen=0;
        HashMap<Integer,Integer>mpp=new HashMap<>();
        for(int high=0;high<n;high++){
            mpp.put(nums[high],mpp.getOrDefault(nums[high],0)+1);
            while(mpp.get(nums[high])>k){
                mpp.put(nums[low],mpp.get(nums[low])-1);
                low++;
            }
            maxLen=Math.max(maxLen,high-low+1);

        }
        return maxLen;
    }
}