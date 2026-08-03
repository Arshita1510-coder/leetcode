class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        for(int x=left;x<=right;x++){
            boolean covered=false;
            for(int[]range:ranges){
                if(range[0]<=x&&x<=range[1]){
                    covered=true;
                    break;
                }
            }
            if(!covered){
              return false;
            }
        
        }
       return true;
        
    }
}