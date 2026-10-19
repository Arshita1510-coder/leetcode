class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count=0;
        int less=0;
        for(int num:nums){
            if(num==target){
                count++;
            }else if(num<target){
                less++;
            }
        }
        List<Integer>result=new ArrayList<>();
        for(int i=0;i<count;i++){
            result.add(less+i);
        }
        return result;
    }
    
}