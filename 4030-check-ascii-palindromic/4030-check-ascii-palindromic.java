class Solution {
    public boolean isPalindromic(String s) {
        
        int left=0;
        int right=s.length()-1;
        while(left<=right){
            int a=s.charAt(left);
            int b=s.charAt(right);
            for(int i=0;i<8;i++){
                int bitA=(a>>(7-i))&1;
                int bitB=(b>>i)&1;
                if(bitA!=bitB){
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }
}