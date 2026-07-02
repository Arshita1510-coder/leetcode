class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer>ans=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(ans.size()==0||ans.get(0)!=nums[i]){
                int Cnt=0;
                for(int j=0;j<n;j++){
                    if(nums[i]==nums[j]){
                        Cnt++;
                    }
                }
                if(Cnt>n/3) ans.add(nums[i]);
            }
            if(ans.size()==2) break;
        }
        return ans;

        
    }
}