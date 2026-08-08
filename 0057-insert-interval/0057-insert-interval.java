
    
   class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];
        boolean insert = false;

        for (int i = 0; i < intervals.length; i++) {

            if (intervals[i][1] < start) {
               
                ans.add(intervals[i]);
            }
            else if (intervals[i][0] > end) {
               
                if (!insert) {
                    ans.add(new int[]{start, end});
                    insert = true;
                }
                ans.add(intervals[i]);
            }
            else {
                
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }

        if (!insert) {
            ans.add(new int[]{start, end});
        }

        return ans.toArray(new int[ans.size()][]);
    }

    }
