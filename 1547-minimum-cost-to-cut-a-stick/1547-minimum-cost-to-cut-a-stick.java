class Solution {
    int findMinimumCost(int i,int j,int[]cuts,int[][]dp){
        if(i>j) return 0;
        int mini=Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int ind=i;ind<=j;ind++){
            int cost=cuts[j+1]-cuts[i-1]+findMinimumCost(i,ind-1,cuts,dp)+findMinimumCost(ind+1,j,cuts,dp);
            mini=Math.min(mini,cost);
        }
        return dp[i][j]=mini;
    }
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[]arr=new int[m+2];
        int c=arr.length-2;
        int[][]dp=new int[c+2][c+2];
        arr[0]=0;
        arr[m+1]=n;
        for(int i=0;i<m;i++){
            arr[i+1]=cuts[i];
        }
        Arrays.sort(arr);
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return findMinimumCost(1,c,arr,dp);
        
        
    }
}