class Solution {
   
      
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][]dp=new int[n][amount+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=0;
            }
        }
        for(int T=0;T<=amount;T++){
            if(T%coins[0]==0) dp[0][T]=T/coins[0];
            else dp[0][T]=(int)1e9;
        }
        for(int ind=1;ind<n;ind++){
            for(int T=0;T<=amount;T++){
                int notTake=dp[ind-1][T];
                int take=Integer.MAX_VALUE;
                if(coins[ind]<=T){
                    take=1+dp[ind][T-coins[ind]];
                }
                dp[ind][T]=Math.min(take,notTake);
            }
        }
      int ans=dp[n-1][amount];
      if(ans>=(int)1e9) return -1;
      return ans;

        
    }
}