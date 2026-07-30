class Solution {
    public int maximumSum(int[] arr) {
        int n=arr.length;
        int pow=0;
        int nopow=arr[0];
        int res=arr[0];
        for(int i=1;i<n;i++){
            int v1=arr[i];
            int v2=nopow+arr[i];
            int v3=pow+arr[i];
            int v4=nopow;
            int ans=Math.max(v1,v2);
            int ans2=Math.max(v3,v4);
             res=Math.max(res,Math.max(ans,ans2));
            nopow=Math.max(v1,v2);
            pow=Math.max(v3,v4);
        }
        return res;
        
    }
}