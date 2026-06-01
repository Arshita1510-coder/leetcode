class Solution {
    public int minimumCost(int[] cost) {
        int n=cost.length;
        int total=0;
        Arrays.sort(cost);
        for(int i=n-1;i>=0;i-=3){
            total+=cost[i];
            if(i-1>=0) total+=cost[i-1];
            
        }
        return total;
        
    }
}