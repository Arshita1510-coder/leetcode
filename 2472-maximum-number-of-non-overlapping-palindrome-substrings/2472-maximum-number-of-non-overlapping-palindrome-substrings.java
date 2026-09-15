class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        boolean[]dp=new boolean[n];
        int count=0;
        int lastEnd=-1;
        for(int end=0;end<n;end++){
            for(int start=0;start<=end;start++){
                int len=end-start+1;
                if(s.charAt(start)==s.charAt(end)){
                    if(len<=2){
                        dp[start]=true;
                    }else{
                        dp[start]=dp[start+1];
                    }
                }else{
                    dp[start]=false;
                }
            }
            for(int start=lastEnd+1;start<=end-k+1;start++){
                if(dp[start]){
                    count++;
                    lastEnd=end;
                    break;
                }
            }
        }
        return count;
        
    }
}