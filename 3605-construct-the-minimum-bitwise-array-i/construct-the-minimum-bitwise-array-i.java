class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
       int n=nums.size();
       int ans[]=new int[n];
       for(int i=0;i<n;i++){
            int target=nums.get(i);
            int found=-1;
            for(int x=0;x<=target;x++){
                if((x|(x+1))==target){
                    found=x;
                    break;
                }
            }
            ans[i]=found;
        }
        return ans;

        
    }
}