class Solution {
    
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==0) return 0;
        int[]ahead=new int[2];
        int[]curr=new int[2];
        ahead[0]=ahead[1]=0;
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                if(buy!=0){
                    profit=Math.max(-prices[ind]+ahead[0],0+ahead[1]);
                }else{
                    profit=Math.max(prices[ind]+ahead[1],0+ahead[0]);
                }
                curr[buy]=profit;
            }
            ahead=curr;
        }
        return ahead[1];

        
        
        
    }
}