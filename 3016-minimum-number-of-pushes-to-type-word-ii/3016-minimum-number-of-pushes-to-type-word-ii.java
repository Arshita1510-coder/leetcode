class Solution {
    public int minimumPushes(String word) {
        int[]freq=new int[26];
        for(char ch:word.toCharArray()){
            freq[ch-'a']++;
        }
        int min=0;
        Arrays.sort(freq);
        for(int i=25,pushCnt=0;i>=0;i--){
            int curr=25-i;
            if(curr%8==0) pushCnt++;
            min+=freq[i]*pushCnt;
        }
        return min;

        
    }
}