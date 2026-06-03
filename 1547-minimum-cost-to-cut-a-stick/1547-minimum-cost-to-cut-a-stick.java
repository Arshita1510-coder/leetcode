class Solution {
    
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        Arrays.sort(cuts);
        int[]arr=new int[m+2];
        int c=arr.length-2;
        int[][]dp=new int[c+2][c+2];
        arr[0]=0;
        arr[m+1]=n;
        for(int i=0;i<m;i++){
            arr[i+1]=cuts[i];
        }
        
        for(int i=c;i>=1;i--){
            for(int j=i;j<=c;j++){
                int mini=Integer.MAX_VALUE;
                for(int ind=i;ind<=j;ind++){
                    int ans=arr[j+1]-arr[i-1]+dp[i][ind-1]+dp[ind+1][j];
                    mini=Math.min(mini,ans);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][c];
        
    }
}