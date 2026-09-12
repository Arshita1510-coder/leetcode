import java.util.*;

class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // Store: [start, end, weight, originalIndex]
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0); // start
            arr[i][1] = intervals.get(i).get(1); // end
            arr[i][2] = intervals.get(i).get(2); // weight
            arr[i][3] = i;                       // original index
        }

        // Sort by start time
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        /*
         * dp[i][k] = best answer starting from i
         * when we can still choose k intervals.
         */
        long[][] dp = new long[n + 1][5];

        /*
         * selected[i][k] stores the indices selected
         * for the best answer.
         */
        List<Integer>[][] selected = new ArrayList[n + 1][5];

        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                // Option 1: Skip current interval
                long skipScore = dp[i + 1][k];
                List<Integer> skipList = selected[i + 1][k];

                // Find next interval whose start > current end
                int next = findNext(arr, i, arr[i][1]);

                // Option 2: Take current interval
                long takeScore = arr[i][2] + dp[next][k - 1];

                List<Integer> takeList = new ArrayList<>();
                takeList.add(arr[i][3]);

                if (selected[next][k - 1] != null) {
                    takeList.addAll(selected[next][k - 1]);
                }

                // Sort indices because final answer must be sorted
                Collections.sort(takeList);

                if (takeScore > skipScore) {
                    dp[i][k] = takeScore;
                    selected[i][k] = takeList;
                }
                else if (takeScore < skipScore) {
                    dp[i][k] = skipScore;
                    selected[i][k] = skipList;
                }
                else {
                    // Same score → choose lexicographically smaller
                    if (isSmaller(takeList, skipList)) {
                        dp[i][k] = takeScore;
                        selected[i][k] = takeList;
                    }
                    else {
                        dp[i][k] = skipScore;
                        selected[i][k] = skipList;
                    }
                }
            }
        }

        List<Integer> answer = selected[0][4];

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }


    // Find first interval with start > currentEnd
    private int findNext(int[][] arr, int index, int currentEnd) {

        int left = index + 1;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid][0] > currentEnd) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }


    // Check whether a is lexicographically smaller than b
    private boolean isSmaller(List<Integer> a, List<Integer> b) {

        if (b == null) {
            return true;
        }

        int size = Math.min(a.size(), b.size());

        for (int i = 0; i < size; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}