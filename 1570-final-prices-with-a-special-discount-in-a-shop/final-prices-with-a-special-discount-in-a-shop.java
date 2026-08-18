class Solution {
    public int[] finalPrices(int[] prices) {
        int[]res=new int[prices.length];
        for(int i=0;i<prices.length;i++){
            int newPrice=prices[i];
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]<=prices[i]){
                    newPrice-=prices[j];
                    break;
                }
            }
            res[i]=newPrice;
        }
        return res;

        
    }
}