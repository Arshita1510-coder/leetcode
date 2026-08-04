class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int[]prefix=new int[n+1];
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        int result=Integer.MAX_VALUE;
        for(int r=1;r<=n;r++){
            int req=prefix[r]-target;
            int low=0;
            int high=r-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(prefix[mid]<=req){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            if(high>=0){
                int len=r-high;
                result=Math.min(result,len);
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }
}