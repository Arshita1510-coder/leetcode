class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
      int[]a=new int[26];
      int[]b=new int[26];
      for(char ch:ransomNote.toCharArray()){
        a[ch-'a']++;
      }
      for(char ch:magazine.toCharArray()){
        b[ch-'a']++;
      }
      for(int i=0;i<26;i++){
        if(a[i]>b[i]){
            return false;
        }
      }
      return true;

        
    }
}