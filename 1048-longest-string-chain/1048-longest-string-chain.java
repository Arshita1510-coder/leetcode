class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int[]dp=new int[n];
        Arrays.fill(dp,1);
        int maxLen=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(checkPossible(words[i],words[j])&&dp[i]<dp[j]+1){
                    dp[i]=1+dp[j];
                }
            }
            if(dp[i]>maxLen){
                maxLen=dp[i];
            }
        }
        return maxLen;
    }
    public static boolean checkPossible(String s,String t){
        if(s.length()!=t.length()+1) return false;
        int i=0,j=0;
        while(i<s.length()){
            if(j<t.length()&&s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return (i==s.length()&&j==t.length());
    }
}