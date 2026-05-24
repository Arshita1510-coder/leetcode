class Solution {
    public static int getAns(int[]prices,int n,int ind,int trans,int[][]dp){
        if(ind==n||trans==4) return 0;
        int profit=0;
        if(dp[ind][trans]!=-1) return dp[ind][trans];
        if(trans%2==0){
            profit=Math.max(-prices[ind]+getAns(prices,n,ind+1,trans+1,dp),0+getAns(prices,n,ind+1,trans,dp));
        }else{
            profit=Math.max(prices[ind]+getAns(prices,n,ind+1,trans+1,dp),0+getAns(prices,n,ind+1,trans,dp));
        }
        return dp[ind][trans]= profit;
    }
    
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][]dp=new int[n][4];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return getAns(prices,n,0,0,dp);
    }
}