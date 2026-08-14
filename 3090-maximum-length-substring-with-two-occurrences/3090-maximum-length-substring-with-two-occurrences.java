class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int low=0;
        HashMap<Character,Integer>freq=new HashMap<>();
        int maxLen=0;
        for(int high=0;high<n;high++){
            freq.put(s.charAt(high),freq.getOrDefault(s.charAt(high),0)+1);
            while(freq.get(s.charAt(high))>2){
                char leftChar=s.charAt(low);
                freq.put(leftChar,freq.get(leftChar)-1);
                low++;
            }
            maxLen=Math.max(maxLen,high-low+1);

        }
        return maxLen;
        
    }
}