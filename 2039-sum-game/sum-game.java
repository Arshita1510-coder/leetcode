class Solution {
    public boolean sumGame(String num) {
        int n=num.length();
        int half=n/2;
        int leftSum=0;
        int rightSum=0;
        int leftQ=0;
        int rightQ=0;
        for(int i=0;i<half;i++){
            char ch=num.charAt(i);
            if(ch=='?'){
                leftQ++;


            }else{
                leftSum+=ch-'0';
            }
        }
        for(int i=half;i<n;i++){
            char ch=num.charAt(i);
            if(ch=='?'){
                rightQ++;
            }else{
                rightSum+=ch-'0';
            }
        }
        if((rightQ-leftQ)%2!=0) return true;
        int diff=leftSum-rightSum;
        int required=(rightQ-leftQ)*9/2;
        return diff!=required;
        
    }
}