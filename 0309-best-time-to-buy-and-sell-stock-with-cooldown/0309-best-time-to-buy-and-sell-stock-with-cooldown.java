class Solution {
   
        
    public static int maxProfit(int[] prices) {
        int n=prices.length;
       
      int[]front1=new int[2];
      int[]front2=new int[2];
     
     
        for(int ind=n-1;ind>=0;ind--){
             int curr[]=new int[2];
                int profit=0;
                
                    curr[1]=Math.max(-prices[ind]+front1[0],0+front1[1]);
                
                
                    curr[0]=Math.max(prices[ind]+front2[1],0+front1[0]);
                
                front2=front1;
                front1=curr;
         
                
            
            
        }
        
        
           
        
        return front1[1];
        
    }
}
