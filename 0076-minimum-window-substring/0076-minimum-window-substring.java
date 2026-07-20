class Solution {
    public String minWindow(String s, String t) {
        int m=t.length();
        int n=s.length();
        if(m>n)  return "";
        int[]hash=new int[256];
        for(int i=0;i<m;i++){
            hash[t.charAt(i)]++;
        }
        int Count=0;
        int minLen=Integer.MAX_VALUE;
        int startIndex=-1;
        int left=0;
        for(int right=0;right<n;right++){
            if(hash[s.charAt(right)]>0){
                Count++;
            }
            hash[s.charAt(right)]--;
            while(Count==m){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    startIndex=left;
                }
                hash[s.charAt(left)]++;
                if(hash[s.charAt(left)]>0){
                    Count--;
                }
                left++;
            }
        }
        return (startIndex==-1)?"":s.substring(startIndex,startIndex+minLen);

        
    }
}