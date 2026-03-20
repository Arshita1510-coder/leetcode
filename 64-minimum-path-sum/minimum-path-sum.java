class Solution {
    public int minPath(int i,int j,int[][]grid,int[][]dp){
        if(i==0&&j==0) return grid[i][j];
        if(i<0||j<0) return(int) 1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=grid[i][j]+minPath(i-1,j,grid,dp);
        int left=grid[i][j]+minPath(i,j-1,grid,dp);
       return dp[i][j]= Math.min(up,left);
     
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][]dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return minPath(n-1,m-1,grid,dp);

        
    }
}