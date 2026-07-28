class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        char[]firstHalf=s.substring(0,n/2).toCharArray();
        Arrays.sort(firstHalf);
        StringBuilder ans=new StringBuilder();
        for(char ch:firstHalf){
            ans.append(ch);
        }
        if(n%2==1){
            ans.append(s.charAt(n/2));
        }
        for(int i=firstHalf.length-1;i>=0;i--){
            ans.append(firstHalf[i]);

        }
        return ans.toString();


        
        
    }
}