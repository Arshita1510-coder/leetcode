class Solution {
   public int f(int ind,int T,int[]coins,int[][]dp){
    //base case
    if(ind==0){
        if(T%coins[0]==0){
            return T/coins[0];
        }else{
            return (int)1e9;
        }
    }
    if(dp[ind][T]!=-1){
        return dp[ind][T];
    }
    int notTake=f(ind-1,T,coins,dp);
    int take=(int)1e9;
    if(coins[ind]<=T){
        take=1+f(ind,T-coins[ind],coins,dp);
    }
    return dp[ind][T]=Math.min(take,notTake);
   }
        
    

    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][]dp=new int[n][amount+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }
        int ans=f(n-1,amount,coins,dp);
        if(ans>=(int)1e9)
           return -1;

        return ans;   

        
    }
}