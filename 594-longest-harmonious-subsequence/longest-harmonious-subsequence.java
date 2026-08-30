class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int i=0;
        int maxLength=0;
        for(int j=0;j<n;j++){
            while(nums[j]-nums[i]>1){
                i++;
            }
            if(nums[j]-nums[i]==1){
                maxLength=Math.max(maxLength,j-i+1);
            }
        }
        return maxLength;
        
    }
}