import java.util.*;

class Solution {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();
        int[][] dist = new int[n][n];

        // Initialize distances
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();

        // Push all thieves into queue (Multi-source BFS)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        // Multi-source BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        int low = 0;
        int high = 2 * n;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReach(dist, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canReach(int[][] dist, int safe) {

        int n = dist.length;

        if (dist[0][0] < safe || dist[n - 1][n - 1] < safe)
            return false;

        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            if (x == n - 1 && y == n - 1)
                return true;

            for (int[] d : dirs) {

                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n &&
                        !vis[nx][ny] &&
                        dist[nx][ny] >= safe) {

                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return false;
    }
}