class Solution {
    public int minimumDifference(int[] nums) {
        int n=nums.length/2;
        int[]left=Arrays.copyOfRange(nums,0,n);
        int[]right=Arrays.copyOfRange(nums,n,2*n);
        List<Integer>[]leftSum=new ArrayList[n+1];
        List<Integer>[]rightSum=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            leftSum[i]=new ArrayList<>();
            rightSum[i]=new ArrayList<>();
        }
        for(int mask=0;mask<(1<<n);mask++){
            int Count=0;
            int sumL=0;
            int sumR=0;
            for(int i=0;i<n;i++){
                if((mask&1<<i)!=0){
                    Count++;
                    sumL+=left[i];
                    sumR+=right[i];

                }
            }
            leftSum[Count].add(sumL);
            rightSum[Count].add(sumR);
        }
        for(int i=0;i<=n;i++){
            Collections.sort(rightSum[i]);
        }
        int total=Arrays.stream(nums).sum();
        int ans=Integer.MAX_VALUE;
        for(int k=0;k<=n;k++){
            for(int a:leftSum[k]){
                int target=total/2-a;
                List<Integer>list=rightSum[n-k];
                int idx=Collections.binarySearch(list,target);
                if(idx<0)idx=-idx-1;

                if(idx < list.size()){
                    int s = a + list.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2*s));
                }

                if(idx > 0){
                    int s = a + list.get(idx-1);
                    ans = Math.min(ans, Math.abs(total - 2*s));
                }
            }
        }
        return ans;
    }
}