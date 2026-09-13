class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;

        ArrayList<int[]> a = new ArrayList<>();
        ArrayList<int[]> b = new ArrayList<>();

        // Store only positions of 1s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (img1[i][j] == 1) {
                    a.add(new int[]{i, j});
                }

                if (img2[i][j] == 1) {
                    b.add(new int[]{i, j});
                }
            }
        }

        HashMap<String, Integer> map = new HashMap<>();

        int ans = 0;

        for (int[] p1 : a) {
            for (int[] p2 : b) {

                int dr = p2[0] - p1[0];
                int dc = p2[1] - p1[1];

                String key = dr + "," + dc;

                int freq = map.getOrDefault(key, 0) + 1;

                map.put(key, freq);

                ans = Math.max(ans, freq);
            }
        }

        return ans;
    }
}