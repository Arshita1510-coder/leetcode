class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int[][]pref=new int[n][m];
        int Count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pref[i][j]=grid[i][j];
                if(i>0) pref[i][j]+=pref[i-1][j];
                if(j>0) pref[i][j]+=pref[i][j-1];
                if(i>0&&j>0) pref[i][j]-=pref[i-1][j-1];
                if(pref[i][j]<=k){
                    Count++;
                }else{
                    break;
                }

            }
        }
        return Count;
        
    }
}