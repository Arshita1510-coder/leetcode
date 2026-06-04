class Solution {
    public static int getAns(int i, int j,int[]nums,int[][]dp){
        if(i>j) return 0;
        int maxi=Integer.MIN_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int ind=i;ind<=j;ind++){
            int cost=nums[i-1]*nums[ind]*nums[j+1]+getAns(i,ind-1,nums,dp)+getAns(ind+1,j,nums,dp);
            maxi=Math.max(maxi,cost);

        }
        return dp[i][j]= maxi;
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n+2];
        int[][]dp=new int[n+1][n+1];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return getAns(1,n,arr,dp);
        
    }
}