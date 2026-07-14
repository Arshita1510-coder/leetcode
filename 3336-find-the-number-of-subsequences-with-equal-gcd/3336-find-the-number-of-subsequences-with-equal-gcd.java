class Solution {
    static final int mod=1000000007;
    public int subsequencePairCount(int[] nums) {
        int max=200;
        long[][]dp=new long[max+1][max+1];
        dp[0][0]=1;
        for(int num:nums){
            long[][]next=new long[max+1][max+1];
            for(int g1=0;g1<=max;g1++){
                for(int g2=0;g2<=max;g2++){
                    if(dp[g1][g2]==0) continue;
                    long ways=dp[g1][g2];
                    next[g1][g2]=(next[g1][g2]+ways)%mod;

                    int newG1=(g1==0)?num:gcd(g1,num);
                    next[newG1][g2]=(next[newG1][g2]+ways)%mod;

                    int newG2=(g2==0)?num:gcd(g2,num);
                    next[g1][newG2]=(next[g1][newG2]+ways)%mod;
                }
            }
            dp=next;
        }
        long ans=0;
        for(int g=1;g<=max;g++){
            ans=(ans+dp[g][g])%mod;
        }
        return (int)ans;
        
    }
    private int gcd(int a,int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}