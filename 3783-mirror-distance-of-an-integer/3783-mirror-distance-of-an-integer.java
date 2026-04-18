class Solution {
    public int mirrorDistance(int n) {
        int ans=Math.abs(n-reverse(n));
        return ans;


        
    }
    private int reverse(int n){
        int rev=0;
        while(n>0){
           
            rev=rev*10+n%10;
            n/=10;
        }
        return rev;
    }
}