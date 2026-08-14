class Solution {
    public int maximumLengthSubstring(String s) {
       int n=s.length();
       int freq[]=new int[26];
       int low=0;
       int maxLen=0;
       for(int high=0;high<n;high++){
        freq[s.charAt(high)-'a']++;
        while(freq[s.charAt(high)-'a']>2){
            freq[s.charAt(low)-'a']--;
            low++;
        }
        maxLen=Math.max(maxLen,high-low+1);

       }
       return maxLen;
        
    }
}