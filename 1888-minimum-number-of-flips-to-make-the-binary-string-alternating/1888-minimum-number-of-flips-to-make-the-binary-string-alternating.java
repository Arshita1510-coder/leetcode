class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String s2 = s + s;

        int diff1 = 0; // mismatches with pattern 010101...
        int diff2 = 0; // mismatches with pattern 101010...

        int left = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < 2 * n; right++) {

            char expected1 = (right % 2 == 0) ? '0' : '1';
            char expected2 = (right % 2 == 0) ? '1' : '0';

            if (s2.charAt(right) != expected1) diff1++;
            if (s2.charAt(right) != expected2) diff2++;

            // maintain window size n
            if (right - left + 1 > n) {

                char leftExpected1 = (left % 2 == 0) ? '0' : '1';
                char leftExpected2 = (left % 2 == 0) ? '1' : '0';

                if (s2.charAt(left) != leftExpected1) diff1--;
                if (s2.charAt(left) != leftExpected2) diff2--;

                left++;
            }

            // when window size becomes n
            if (right - left + 1 == n) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}