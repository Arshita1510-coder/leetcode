class Solution {
    
    int[] dr = {-1, 0, 1, 0}; // up, right, down, left
    int[] dc = {0, 1, 0, -1};
    
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][]vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]){
                    if(dfs(grid,vis,i,j,-1,-1))
                        return true;
                }
            }
        }
        return false;
        
    }
    public boolean dfs(char[][]grid,boolean[][]vis,int r,int c,int pr,int pc){
        vis[r][c]=true;
        for(int k=0;k<4;k++){
            int nr=r+dr[k];
            int nc=c+dc[k];
            if(nr<0||nc<0||nr>=grid.length||nc>=grid[0].length){
                continue;
            }
            if(grid[nr][nc]!=grid[r][c]){
                continue;
            }
            if(vis[nr][nc]&&!(nr==pr&&nc==pc))
                 return true;

             if(!vis[nr][nc]){
                if(dfs(grid,vis,nr,nc,r,c))
                    return true;
             }  
        }
        return false;
    }
}