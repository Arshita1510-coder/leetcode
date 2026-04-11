class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        long[][]dp=new long[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                dp[0][i]=1;
            }
        }
        for(int ind=1;ind<n;ind++){
            for(int target=0;target<=amount;target++){
                long nottake=dp[ind-1][target];
                long take=0;
                if(coins[ind]<=target){
                    take=dp[ind][target-coins[ind]];
                }
                dp[ind][target]=nottake+take;

            }
        }
        return (int)dp[n-1][amount];
        
    }
}