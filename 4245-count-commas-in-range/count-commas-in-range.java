class Solution {
    public int countCommas(int n) {
       while(n<1000){
          return 0;
       }
       return n-999;
        
    }
}