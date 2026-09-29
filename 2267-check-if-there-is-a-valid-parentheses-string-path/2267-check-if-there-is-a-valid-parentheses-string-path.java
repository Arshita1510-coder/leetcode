class Solution {
    int m,n;
    byte[][][]dp;
    public boolean hasValidPath(char[][] grid) {
         m=grid.length;
         n=grid[0].length;
         if((m+n-1)%2!=0){
            return false;
         }
         if(grid[0][0]==')') return false;
         dp=new byte[m][n][m+n]; 
         return dfs(0,0,0,grid);
        

        
    }
    private boolean dfs(int i,int j,int balance,char[][]grid){
        
        if(grid[i][j]=='('){
            balance++;
        }else{
            balance--;
        }
        if(balance<0) return false;
        int remaining=(m-1-i)+(n-1-j);
        if(balance>remaining) return false;
        if(i==m-1&&j==n-1){
            return balance==0;
        }
        if(dp[i][j][balance]!=0){
            return dp[i][j][balance]==2;
        }
        boolean ans=false;
        if(i+1<m){
            ans=dfs(i+1,j,balance,grid);
        }
        if(!ans&&j+1<n){
            ans=dfs(i,j+1,balance,grid);
        }
        dp[i][j][balance]=(byte)(ans?2:1);
        return ans;

    }
}