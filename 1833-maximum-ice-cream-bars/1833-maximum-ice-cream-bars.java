class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int Count=0;
        for(int val:costs){
            if(val>coins) break;
            Count++;
            coins=coins-val;
        }
        return Count;
        






        
        
    }
}