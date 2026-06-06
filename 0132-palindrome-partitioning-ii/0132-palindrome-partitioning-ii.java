class Solution {
    public static boolean isPalindrome(int i,int j,String s,int[]dp){

      while(i<j){
        if(s.charAt(i)!=s.charAt(j)) return false;
        i++;
        j--;
      }
      return true;
    }
    public static int f(int i,int n,String s,int[]dp){
        if(i==n) return 0;
        int minCost=Integer.MAX_VALUE;
        if(dp[i]!=-1) return dp[i];
        for(int j=i;j<n;j++){
            if(isPalindrome(i,j,s,dp)){
                int cost=1+f(j+1,n,s,dp);
                minCost=Math.min(cost,minCost);
            }
        }
        return dp[i]=minCost;
    }
    public int minCut(String s) {
        int n=s.length();
        int[]dp=new int[n];
        Arrays.fill(dp,-1);
        return f(0,n,s,dp)-1;

        
    }
}