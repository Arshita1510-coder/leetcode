class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        int[]prefix=new int[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+stoneValue[i];
        }
        int[][]dp=new int[n][n];
        for(int len=2;len<=n;len++){
            for(int i=0;i+len<=n;i++){
                int j=i+len-1;
                for(int k=i;k<j;k++){
                    int leftSum=prefix[k+1]-prefix[i];
                    int rightSum=prefix[j+1]-prefix[k+1];
                    int score;
                    if(leftSum<rightSum){
                        score=leftSum+dp[i][k];
                    }else if(rightSum<leftSum){
                        score=rightSum+dp[k+1][j];
                    }else{
                        score=leftSum+Math.max(dp[i][k],dp[k+1][j]);
                    }
                    dp[i][j]=Math.max(dp[i][j],score);
                }
            }
        }
        return dp[0][n-1];
        
    }
}