class Solution {
    
    
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][]dp=new int[n+1][5];
        
        for(int ind=n-1;ind>=0;ind--){
            for(int trans=3;trans>=0;trans--){
                if(trans%2==0){
                     dp[ind][trans]=Math.max(-prices[ind]+dp[ind+1][trans+1],0+dp[ind+1][trans]);
               }else{
                    dp[ind][trans]=Math.max(prices[ind]+dp[ind+1][trans+1],0+dp[ind+1][trans]);
               }
            }
        }
        return dp[0][0];
        

            
        
         
        
       
    }
}