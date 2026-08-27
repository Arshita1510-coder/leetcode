class Solution {
    public int longestPalindrome(String s) {
        int n=s.length();
        HashMap<Character,Integer>mpp=new HashMap<>();
        for(char ch:s.toCharArray()){
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
        }
        boolean odd=false;
        int res=0;
        for(char ch:mpp.keySet()){
            int val=mpp.get(ch);
            if(val%2==0) res+=val;
            else{
                res+=val-1;
                odd=true;
            }


        }
        
        return odd? res+1:res;
    }
   
}