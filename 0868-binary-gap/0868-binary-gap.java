class Solution {
    public int binaryGap(int n) {
        String binary=Integer.toBinaryString(n);
        int prev=-1;
        int max=0;
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='1'){
                if(prev!=-1){
                    int distance=i-prev;
                    max=Math.max(max,distance);

                }
                prev=i;

            }
        }
        return max;
        
    }
}