class Solution {
    public int maxDepth(String s) {
        int ans=0;
        int p=0;
        for(char c:s.toCharArray()){
            if(c=='(') p++;
            else if(c==')') p--;
            ans=Math.max(ans,p);
        }
        return ans;
        
    }
}