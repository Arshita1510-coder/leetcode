class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int Count=0;
        for(String s:patterns){
            if(word.indexOf(s)!=-1) Count++;
        }
        return Count;
        
    }
}