class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        boolean[]covered=new boolean[101];
        for(List<Integer>car:nums){
            int start=car.get(0);
            int end=car.get(1);
            for(int i=start;i<=end;i++){
                covered[i]=true;
            }
        }
        int count=0;
        for(boolean x:covered){
            if(x){
                count++;
            }
        }
        return count;

        
    }
}