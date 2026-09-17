class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int inf=Integer.MAX_VALUE;
        int[]best=new int[n+1];
        for(int i=0;i<=n;i++){
            best[i]=inf;
        }
        int left=0;
        int sum=0;
        int ans=inf;
        for(int right=0;right<n;right++){
            sum+=arr[right];
            while(sum>target){
                sum-=arr[left];
                left++;
            }
            if(sum==target){
                int len=right-left+1;
                if(best[left]!=inf){
                    ans=Math.min(ans,len+best[left]);
                }
                best[right+1]=Math.min(best[right+1],len);
            }
            best[right+1]=Math.min(best[right+1],best[right]);
        }
        return ans==inf?-1:ans;
    }

}