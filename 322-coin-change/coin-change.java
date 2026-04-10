class Solution {
   
      
    public int coinChange(int[] coins, int amount) {
        int prev[]=new int[amount+1];
        int curr[]=new int[amount+1];
        int n=coins.length;
       
       
        for(int T=0;T<=amount;T++){
            if(T%coins[0]==0) prev[T]=T/coins[0];
            else prev[T]=(int)1e9;
        }
        for(int ind=1;ind<n;ind++){
            for(int T=0;T<=amount;T++){
                int notTake=prev[T];
                int take=Integer.MAX_VALUE;
                if(coins[ind]<=T){
                    take=1+curr[T-coins[ind]];
                }
                curr[T]=Math.min(take,notTake);
            }
            prev=curr;
        }
      int ans=prev[amount];
      if(ans>=(int)1e9) return -1;
      return ans;

        
    }
}