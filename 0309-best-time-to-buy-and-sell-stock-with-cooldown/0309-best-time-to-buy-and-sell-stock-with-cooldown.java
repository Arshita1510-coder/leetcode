class Solution {
   
        
    public static int maxProfit(int[] prices) {
        int n=prices.length;
        int[][]dp=new int[n+2][2];
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                if(buy!=0){
                    profit=Math.max(-prices[ind]+dp[ind+1][0],0+dp[ind+1][1]);
                }else{
                    profit=Math.max(prices[ind]+dp[ind+2][1],0+dp[ind+1][0]);
                }
                dp[ind][buy]=profit;
            }
           
           
        }
        return dp[0][1];
        
    }
}