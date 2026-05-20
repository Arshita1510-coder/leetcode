class Solution {
    public boolean wildCardMatching(String p,String s,int i,int j,Boolean[][]dp){
        if(i==00&&j==00) return true;
        if(i==0&&j>0) return false;
        if(j==0&&i>0){
            for(int k=1;k<=i;k++){
                if(p.charAt(k-1)!='*')
                   return false;
            }
            return true;
        }
        if(dp[i][j]!=null) return dp[i][j];

        if(p.charAt(i-1)==s.charAt(j-1)||p.charAt(i-1)=='?'){
             return dp[i][j]= wildCardMatching(p,s,i-1,j-1,dp);

        }if(p.charAt(i-1)=='*'){
             return dp[i][j]= (wildCardMatching(p,s,i-1,j,dp)||wildCardMatching(p,s,i,j-1,dp));
        }
        return dp[i][j]=false;
    }
    public boolean isMatch(String s, String p) {
        int n=p.length();
        int m=s.length();
        Boolean[][]dp=new Boolean[n+1][m+1];
        
        return wildCardMatching(p,s,n,m,dp);

        
    }
}