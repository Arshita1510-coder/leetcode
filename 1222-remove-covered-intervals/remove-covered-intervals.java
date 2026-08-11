class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int ans=intervals.length;
        int start1=intervals[0][0];
        int end1=intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]==start1||intervals[i][1]<=end1){
                ans--;
            }else{
                start1=intervals[i][0];
                end1=intervals[i][1];
            }
        }
        return ans;

        
    }
}