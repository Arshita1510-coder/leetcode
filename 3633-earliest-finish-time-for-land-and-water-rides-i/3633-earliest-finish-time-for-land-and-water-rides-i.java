class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n=landStartTime.length;
        int m=waterStartTime.length;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int landFinish=landStartTime[i]+landDuration[i];
                int landToWater=Math.max(landFinish,waterStartTime[j])+waterDuration[j];

                int waterFinish=waterStartTime[j]+waterDuration[j];
                int waterToLand=Math.max(waterFinish,landStartTime[i])+landDuration[i];

                ans=Math.min(ans,Math.min(landToWater,waterToLand));
            }
        }
        return ans;
    }
}