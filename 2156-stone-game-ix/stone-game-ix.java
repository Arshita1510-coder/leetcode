class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[]Cnt=new int[3];
        for(int x:stones){
            Cnt[x%3]++;
        }
        int zero=Cnt[0];
        int one=Cnt[1];
        int two=Cnt[2];
        if(one==0||two==0){
            return Math.max(one,two)>2&&zero%2==1;
        }
        return Math.abs(one-two)>2||zero%2==0;
        
    }
}