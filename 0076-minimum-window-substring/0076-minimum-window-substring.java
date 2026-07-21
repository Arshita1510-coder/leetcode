class Solution {
    public String minWindow(String s, String t) {
       int minLen=Integer.MAX_VALUE;
       int[]hash=new int[256];
       int left=0;
       int right=0;
       int sIndex=-1;
       int m=t.length();
       int n=s.length();
       for(int i=0;i<m;i++) hash[t.charAt(i)]++;
       int Cnt=0;
       while(right<n){
        if(hash[s.charAt(right)]>0) Cnt+=1;
        hash[s.charAt(right)]--;
        while(Cnt==m){
            if(right-left+1<minLen){
                minLen=right-left+1;
                sIndex=left;
            }
            hash[s.charAt(left)]++;
            
            if(hash[s.charAt(left)]>0) Cnt--;
            left++;
        } 
        right++;
       }
       return sIndex==-1?"":s.substring(sIndex,sIndex+minLen);
    }
}