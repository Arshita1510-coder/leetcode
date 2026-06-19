class Solution {
    public int largestAltitude(int[] gain) {
        int res=0;
        int max=0;
        for(int val:gain){
            res+=val;
            max=Math.max(max,res);
        }
        return max;
        
    }
}