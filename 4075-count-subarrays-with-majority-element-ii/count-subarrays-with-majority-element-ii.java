class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) nums[i] = 1;
            else nums[i] = -1;
        }
        int[] pref = new int[n];
        pref[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + nums[i];
        }
        int shi = n;
        int[] freq = new int[2 * n + 1];
        freq[shi] = 1;
        long valid = 0;
        int lastSum = 0;

        for (int i = 0; i < n; i++) {
            if (pref[i] > lastSum) {
                valid += freq[lastSum + shi];
            } else {
                valid -= freq[pref[i] + shi];
            }

            cnt += valid;
            freq[pref[i] + shi]++;
            lastSum = pref[i];
        }

        return cnt;
    }
}