class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int Count=0;
        char ch1[]=jewels.toCharArray();
        char ch2[]=stones.toCharArray();
        for(int i =0;i<ch2.length;i++){
            for(int j=0;j<ch1.length;j++){
                if(ch2[i]==ch1[j]){
                    Count++;
                    break;
                }
            }
        }
        return Count;
    }
}