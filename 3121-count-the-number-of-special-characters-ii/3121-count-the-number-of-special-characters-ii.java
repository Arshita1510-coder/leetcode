class Solution {
    public int numberOfSpecialChars(String word) {
        boolean lower[]=new boolean[26];
        boolean upper[]=new boolean[26];
        boolean bad[]=new boolean[26];
        for(char ch:word.toCharArray()){
            if(Character.isLowerCase(ch)){
                int idx=ch-'a';
                lower[idx]=true;

            
              if(upper[idx]==true){
                bad[idx]=true;
              }
            }else{
                int idx=ch-'A';
                upper[idx]=true;
            }
           
        }
        int ans=0;
        for(int i=0;i<26;i++){
            if(lower[i]&&upper[i]&&!bad[i]){
                ans++;
            }
        }
        return ans;
    
    }
}
