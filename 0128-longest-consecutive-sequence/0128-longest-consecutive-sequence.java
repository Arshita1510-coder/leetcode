class Solution {
    
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        int n=nums.length;
        int longest=1;
        Set<Integer>st=new HashSet<>();
        for(int i=0;i<n;i++){
            st.add(nums[i]);
        }
        for(int it:st){
            if(!st.contains(it-1)){
                int Cnt=1;
                int x=it;
                while(st.contains(x+1)){
                    x=x+1;
                    Cnt++;
                }
                longest=Math.max(longest,Cnt);
            }
        }
        return longest;
    }
}