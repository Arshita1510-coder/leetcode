class Solution {
    static final long MOD=(long)1e9+7;
    public int countGoodNumbers(long n) {
        long evenCount=(n+1)/2;
        long oddCount=n/2;
        long evenWays=power(5,evenCount);
        long oddWays=power(4,oddCount);
        long result=(evenWays*oddWays)%MOD;
        return (int)result;
    }
    private long power(long base,long exp){
        long result=1;
        base=base%MOD;
        while(exp>0){
            if((exp&1)==1){
                result=(result*base)%MOD;
            }
            base=(base*base)%MOD;
            exp>>=1;
        }
        return result;
    }
}

        

        
        
    
