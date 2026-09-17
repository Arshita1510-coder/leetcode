class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int INF = Integer.MAX_VALUE;

        int[] best = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            best[i] = INF;
        }

        int left = 0;
        int sum = 0;
        int ans = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {

                int len = right - left + 1;

                // Previous subarray must be completely before 'left'
                if (best[left] != INF) {
                    ans = Math.min(ans, len + best[left]);
                }

                best[right + 1] = Math.min(best[right + 1], len);
            }

            // Carry forward the best subarray found so far
            best[right + 1] = Math.min(best[right + 1], best[right]);
        }

        return ans == INF ? -1 : ans;
    }
}