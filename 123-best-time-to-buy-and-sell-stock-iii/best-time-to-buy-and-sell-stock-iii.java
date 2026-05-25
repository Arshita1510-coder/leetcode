class Solution {
    
    
    public int maxProfit(int[] prices) {
        int n=prices.length;
       int[]ahead=new int[5];
       int[]curr=new int[5];
        
        for(int ind=n-1;ind>=0;ind--){
            for(int trans=3;trans>=0;trans--){
                if(trans%2==0){
                     curr[trans]=Math.max(-prices[ind]+ahead[trans+1],0+ahead[trans]);
               }else{
                    curr[trans]=Math.max(prices[ind]+ahead[trans+1],0+ahead[trans]);
               }
            }
            ahead=curr;
        }
        return ahead[0];
        

            
        
         
        
       
    }
}