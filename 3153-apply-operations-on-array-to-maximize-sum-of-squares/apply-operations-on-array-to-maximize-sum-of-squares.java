class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long mod = 1000000007;
        int[] bitCount = new int[31];

        for (int num : nums) {
            for (int b = 0; b < 31; b++) {
                if ((num & (1 << b)) != 0) {
                    bitCount[b]++;
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {
            long num = 0;

            for (int b = 0; b < 31; b++) {
                if (bitCount[b] > 0) {
                    num |= (1L << b);
                    bitCount[b]--;
                }
            }

            ans = (ans + num * num) % mod;
        }

        return (int) ans;
    }
}