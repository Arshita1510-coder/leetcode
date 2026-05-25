class Solution {
    public static int getAns(int[]prices,int n,int ind,int buy,int cap,int[][][]dp){
        if(ind==n||cap==0) return 0;
        if(dp[ind][buy][cap]!=-1) return dp[ind][buy][cap];
        int profit=0;
        if(buy!=0){
            profit=Math.max(-prices[ind]+getAns(prices,n,ind+1,0,cap,dp),0+getAns(prices,n,ind+1,1,cap,dp));
        }else{
            profit=Math.max(prices[ind]+getAns(prices,n,ind+1,1,cap-1,dp),0+getAns(prices,n,ind+1,0,cap,dp));
        }
        dp[ind][buy][cap]=profit;
        return profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][]dp=new int[n][2][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return getAns(prices,n,0,1,k,dp);
        
    }
}