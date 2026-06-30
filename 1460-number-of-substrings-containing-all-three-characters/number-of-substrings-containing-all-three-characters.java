class Solution {
    public int numberOfSubstrings(String s) {
       int Count = 0;
       int n = s.length();
       int[]lastSeen={-1,-1,-1};
       for(int i=0;i<n;i++){
        lastSeen[s.charAt(i)-'a']=i;
        if(lastSeen[0]!=-1&&lastSeen[1]!=-1&&lastSeen[2]!=-1){
            int minIndex=Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2]));
            Count+=(1+minIndex);

        }
       }
       return Count;
    }
}
       




