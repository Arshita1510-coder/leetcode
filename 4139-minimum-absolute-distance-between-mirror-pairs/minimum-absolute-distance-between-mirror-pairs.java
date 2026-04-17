import java.util.*;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int minDist = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            // check if current number matches reverse of some previous number
            if (map.containsKey(nums[j])) {
                int i = map.get(nums[j]);
                minDist = Math.min(minDist, j - i);
            }

            // store reverse of current number
            int rev = reverse(nums[j]);
            map.put(rev, j);
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }
}