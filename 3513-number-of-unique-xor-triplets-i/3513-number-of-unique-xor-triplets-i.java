class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;
        int pos=0;
        for(int num:nums){
            pos|=num;

        }
        return pos+1;
        
    }
}