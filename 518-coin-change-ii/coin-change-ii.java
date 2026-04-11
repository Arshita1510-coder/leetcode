class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        long[]prev=new long[amount+1];
        
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                prev[i]=1;
            }
        }
        for(int ind=1;ind<n;ind++){
            long curr[]=new long[amount+1];
            for(int target=0;target<=amount;target++){
                long nottake=prev[target];
                long take=0;
                if(coins[ind]<=target){
                    take=curr[target-coins[ind]];
                }
                curr[target]=nottake+take;

            }
            prev=curr;
        }
        return (int)prev[amount];
        
    }
}