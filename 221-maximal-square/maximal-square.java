class Solution {
    
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][]dp=new int[n][m];
        int maxSide=0;
        dp[0][0]=matrix[0][0]-'0';
        maxSide=dp[0][0];
        for(int i=1;i<n;i++){
            dp[i][0]=matrix[i][0]-'0';
            maxSide=Math.max(maxSide,dp[i][0]);
        }
        for(int j=1;j<m;j++){
            dp[0][j]=matrix[0][j]-'0';
            maxSide=Math.max(maxSide,dp[0][j]);
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]=='0'){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                }
                maxSide=Math.max(maxSide,dp[i][j]);

            }
        }
        return maxSide*maxSide;
        
    }
}