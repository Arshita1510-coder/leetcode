class Solution {
    public int concatenatedBinary(int n) {
        StringBuilder sb= new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(Integer.toBinaryString(i));
        }
        String binaryString=sb.toString();
        long result=0;
        int mod=1000000007;
        for(int i=0;i<binaryString.length();i++){
            result=(result*2+(binaryString.charAt(i)-'0'))%mod;
        }
        return (int) result;
        
    }
}