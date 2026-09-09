class Solution {
    public long countCommas(long n) {
       long ans=0;
       long comma=1;
       long start=1000;
       while(start<=n){
        long end=start*1000-1;
        if(n<end){
            end=n;
        }
        long count=end-start+1;
        ans+=count*comma;
        start*=1000;
        comma++;
       }
       return ans;

    }
}