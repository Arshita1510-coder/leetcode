class Solution {
   
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        long[]prev=new long[m+1];
        long[]curr=new long[m+1];
        prev[0]=1;
        for(int i=1;i<=n;i++){
            curr[0]=1;
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    curr[j]=prev[j-1]+prev[j];
                }else{
                    curr[j]=prev[j];
                }
            }
            long[]temp=prev;
            prev=curr;
            curr=temp;
        }
        return (int)prev[m];

    }
}