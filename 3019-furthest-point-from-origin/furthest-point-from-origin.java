class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n=moves.length();
        int countL=0;
        int countR=0;
        int count_=0;
        int ans=0;
        for(int i=0;i<n;i++){
            if(moves.charAt(i)=='L'){
                countL++;
            }else if(moves.charAt(i)=='R'){
                countR++;
            }else{
                count_++;
            }
            ans=Math.abs(countL-countR)+count_;
        }
        return ans;
        
    }
}