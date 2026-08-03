class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n=nums.length;
        int[]prefix=new int[n+1];
        prefix[0]=0;
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        int[]ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int query=queries[i];
            int left=0;
            int right=n;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(prefix[mid]<=query){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            ans[i]=right;
        }
        return ans;

        
    }
}