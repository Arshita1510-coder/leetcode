class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        int zeros=0;
        int ones=0;
        int res=0;
        HashMap<Integer,Integer>mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            if(nums[i]==0) zeros++;
            else ones++;

            int diff=zeros-ones;
            if(diff==0){
                res=Math.max(res,i+1);
                continue;
            }
            if(!mpp.containsKey(diff)){
                mpp.put(diff,i);
            }else{
                int idx=mpp.get(diff);
                int len=i-idx;
                res=Math.max(len,res);
            }
        }
        return res;
        
    }
}