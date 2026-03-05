class Solution {
    public int minOperations(String s) {
        int flipStart0=0;
        int flipStart1=0;
        for(int i=0;i<s.length();i++){
            char expected0=(i%2==0)?'0':'1';
            char expected1=(i%2==0)?'1':'0';
            if(s.charAt(i)!=expected0){
                flipStart0++;
            }
            if(s.charAt(i)!=expected1){
                flipStart1++;
            }
            
        }
        return Math.min(flipStart0,flipStart1);
    }
}