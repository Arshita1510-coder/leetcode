class Solution {

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0)
                continue;

            int slow = i;
            int fast = i;
            boolean forward = nums[i] > 0;

            while (true) {

                slow = next(nums, slow, forward);
                if (slow == -1)
                    break;

                fast = next(nums, fast, forward);
                if (fast == -1)
                    break;

                fast = next(nums, fast, forward);
                if (fast == -1)
                    break;

                if (slow == fast)
                    return true;
            }

            int curr = i;
            while (nums[curr] != 0 && (nums[curr] > 0) == forward) {
                int next = ((curr + nums[curr]) % n + n) % n;
                nums[curr] = 0;
                curr = next;
            }
        }

        return false;
    }

    private int next(int[] nums, int curr, boolean forward) {

        if ((nums[curr] > 0) != forward)
            return -1;

        int n = nums.length;
        int next = ((curr + nums[curr]) % n + n) % n;

        if (next == curr)
            return -1;

        return next;
    }
}