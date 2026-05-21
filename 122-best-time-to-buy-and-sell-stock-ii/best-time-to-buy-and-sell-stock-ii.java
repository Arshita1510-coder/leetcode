class Solution {
    public int getAns(int[]prices,int ind,int buy,int n,int[][]dp){
        if(ind==n){
            return 0;
        }
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit=0;
        if(buy!=0){
            profit=Math.max(-prices[ind]+getAns(prices,ind+1,0,n,dp),0+getAns(prices,ind+1,1,n,dp));
        }else{
            profit=Math.max(prices[ind]+getAns(prices,ind+1,1,n,dp),(0+getAns(prices,ind+1,0,n,dp)));
        }
        return dp[ind][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][]dp=new int[n][2];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }

        return getAns(prices,0,1,n,dp);
        
        
    }
}