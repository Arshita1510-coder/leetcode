class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character>set=new HashSet<>();
        for(char ch:jewels.toCharArray()){
            set.add(ch);
        }
        int Count=0;
        for(char ch:stones.toCharArray()){
            if(set.contains(ch)){
                Count++;
            }
        }
        return Count;
    }
}