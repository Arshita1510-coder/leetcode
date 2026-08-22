class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int prod=1;
        int org=n;
        while(n!=0){
            int rem=n%10;
            sum+=rem;
            prod*=rem;
            n/=10;

        }
        if(org%(sum+prod)==0){
            return true;
        }
        return false;
        
    }
}