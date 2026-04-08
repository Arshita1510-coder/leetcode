class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod=1000000007;
        
        for(int[]q:queries){
                int l=q[0];
                int r=q[1];
                int k=q[2];
                int v=q[3];

                for(int idx=l;idx<=r;idx+=k){
                    long val=(1L*nums[idx]*v)%mod;
                    nums[idx]=(int)val;
                }
        }
        int xor=0;
        for(int num:nums){
            xor^=num;
        }
        return xor;

        
    }
}