class Solution {
    public char findTheDifference(String s, String t) {
        int Sum=0;
        for(int i=0;i<t.length();i++){
            Sum+=t.charAt(i);
        }
        for(int i=0;i<s.length();i++){
            Sum-=s.charAt(i);
        }
        return(char) Sum;
        
    }
}