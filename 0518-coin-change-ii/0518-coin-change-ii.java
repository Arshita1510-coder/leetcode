class Solution {
    private long countWaysToMakeChangeUtil(int amount,int ind,int coins[],long[][]dp) {
          
    
     if(ind==0){
        return(amount%coins[0]==0)?1:0;
     }
     if(dp[ind][amount]!=-1) return dp[ind][amount];
     long notTake=countWaysToMakeChangeUtil(amount,ind-1,coins,dp);
     long take=0;
     if(coins[ind]<=amount){
        take=countWaysToMakeChangeUtil(amount-coins[ind],ind,coins,dp);
     }
     return dp[ind][amount]=take+notTake;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        long[][]dp=new long[n][amount+1];
        for(long[]row:dp) Arrays.fill(row,-1);
        return (int)countWaysToMakeChangeUtil(amount,n-1,coins,dp);
        
    }
}