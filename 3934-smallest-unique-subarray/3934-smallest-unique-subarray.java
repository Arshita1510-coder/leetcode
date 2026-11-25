
import java.util.*;

class Solution {

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        // Step 1: Coordinate compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int[] unique = new int[n];
        int m = 0;

        for (int x : sorted) {
            if (m == 0 || unique[m - 1] != x) {
                unique[m++] = x;
            }
        }

        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = Arrays.binarySearch(unique, 0, m, nums[i]);
        }

        // Step 2: Build Suffix Array
        int[] sa = new int[n];
        int[] temp = new int[n];
        int[] newRank = new int[n];

        for (int i = 0; i < n; i++) {
            sa[i] = i;
        }

        int classes = m;

        for (int k = 1; k < n; k *= 2) {

            countingSort(sa, temp, rank, k, classes);
            countingSort(temp, sa, rank, 0, classes);

            int newClasses = 1;
            newRank[sa[0]] = 0;

            for (int i = 1; i < n; i++) {

                int a = sa[i - 1];
                int b = sa[i];

                int a1 = rank[a];
                int b1 = rank[b];

                int a2 = (a + k < n) ? rank[a + k] : -1;
                int b2 = (b + k < n) ? rank[b + k] : -1;

                if (a1 != b1 || a2 != b2) {
                    newClasses++;
                }

                newRank[b] = newClasses - 1;
            }

            int[] swap = rank;
            rank = newRank;
            newRank = swap;

            classes = newClasses;

            if (classes == n) {
                break;
            }
        }

        // Step 3: Build LCP Array using Kasai
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[sa[i]] = i;
        }

        int[] lcp = new int[n];
        int h = 0;

        for (int i = 0; i < n; i++) {

            int r = pos[i];

            if (r == 0) {
                continue;
            }

            int j = sa[r - 1];

            while (i + h < n && j + h < n &&
                   nums[i + h] == nums[j + h]) {
                h++;
            }

            lcp[r] = h;

            if (h > 0) {
                h--;
            }
        }

        // Step 4: Find minimum unique subarray length
        int ans = n;

        for (int r = 0; r < n; r++) {

            int i = sa[r];

            int left = lcp[r];

            int right = (r + 1 < n) ? lcp[r + 1] : 0;

            int need = Math.max(left, right) + 1;

            if (need <= n - i) {
                ans = Math.min(ans, need);
            }
        }

        return ans;
    }

    // Counting Sort
    private void countingSort(int[] input, int[] output,
                              int[] rank, int offset, int classes) {

        int[] count = new int[classes + 1];

        for (int x : input) {

            int key = (x + offset < rank.length)
                    ? rank[x + offset] + 1 : 0;

            count[key]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = input.length - 1; i >= 0; i--) {

            int x = input[i];

            int key = (x + offset < rank.length)
                    ? rank[x + offset] + 1 : 0;

            output[--count[key]] = x;
        }
    }
}
