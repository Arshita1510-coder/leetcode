class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        HashMap<Integer,Integer>mp=new HashMap<>();
        int[]ans=new int[2];
        ans[0]=ans[1]=-1;
        for(int i=0;i<n;i++){
            int num=nums[i];
            int complement=target-num;
            if(mp.containsKey(complement)){
                ans[0]=mp.get(complement);
                ans[1]=i;

            }
            mp.put(nums[i],i);
        }
        return ans;
    }
}