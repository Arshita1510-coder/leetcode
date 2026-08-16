class Solution {
    public long solve(List<Integer>arr){
        int n=arr.size();
        if(n==1) return arr.get(0);
        long prev=arr.get(0);
        long prev2=0;
        for(int i=1;i<n;i++){
            long pick=arr.get(i);
            if(i>1) pick+=prev2;
            long notPick=prev;
            long curri=Math.max(pick,notPick);
            prev2=prev;
            prev=curri;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        List<Integer>arr1=new ArrayList<>();
        List<Integer>arr2=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i!=0) arr1.add(nums[i]);
            if(i!=n-1) arr2.add(nums[i]);
        }
        return (int)Math.max(solve(arr1),solve(arr2));
    }
       
}