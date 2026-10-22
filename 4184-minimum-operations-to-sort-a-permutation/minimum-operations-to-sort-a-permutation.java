class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }

        boolean ascending = true;
        boolean descending = true;

        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;

            if (nums[next] != (nums[i] + 1) % n) {
                ascending = false;
            }

            if (nums[next] != (nums[i] - 1 + n) % n) {
                descending = false;
            }
        }

        if (ascending) {
            return Math.min(zero, n - zero + 2);
        }

        if (descending) {
            int shift = n - 1 - zero;
            return 1 + Math.min(shift, n - shift);
        }

        return -1;
    }
}