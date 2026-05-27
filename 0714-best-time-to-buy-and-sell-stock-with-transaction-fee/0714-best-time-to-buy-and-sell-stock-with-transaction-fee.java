class Solution {
    public static int getAns(int[]prices,int n,int ind,int buy,int fee,int[][]dp){
        if(ind==n) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit=0;
        if(buy!=0){
            profit=Math.max(-prices[ind]+getAns(prices,n,ind+1,0,fee,dp),0+getAns(prices,n,ind+1,1,fee,dp));
        }else{
            profit=Math.max(prices[ind]-fee+getAns(prices,n,ind+1,1,fee,dp),0+getAns(prices,n,ind+1,0,fee,dp));
        }
        return dp[ind][buy]=profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][]dp=new int[n][2];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        if(n==0) return 0;
        return getAns(prices,n,0,1,fee,dp);
        
    }
}