class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low=0;
        int res=0;
        int n=s.length();
        HashMap<Character,Integer>freq=new HashMap<>();
        for(int high=0;high<n;high++){
            char ch=s.charAt(high);
            freq.put(ch,freq.getOrDefault(ch,0)+1);
            int k=high-low+1;
            while(freq.size()<k){
                freq.put(s.charAt(low),freq.get(s.charAt(low))-1);
                if(freq.get(s.charAt(low))==0){
                    freq.remove(s.charAt(low));
                }
                low++;
                k=high-low+1;
            }
            int len=high-low+1;
            res=Math.max(res,len);
        }
        return res;
        
    }
}