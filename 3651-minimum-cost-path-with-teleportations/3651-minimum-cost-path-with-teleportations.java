import java.util.*;

class Solution {

    static class State {
        int r, c, used, cost;

        State(int r, int c, int used, int cost) {
            this.r = r;
            this.c = c;
            this.used = used;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dist = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        PriorityQueue<State> pq = new PriorityQueue<>(
            (a, b) -> a.cost - b.cost
        );

        // ✅ Start with cost = 0
        dist[0][0][0] = 0;
        pq.offer(new State(0, 0, 0, 0));

        int[] dr = {0, 1};
        int[] dc = {1, 0};

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            int r = cur.r, c = cur.c;
            int used = cur.used;
            int cost = cur.cost;

            if (cost > dist[r][c][used]) continue;

            if (r == m - 1 && c == n - 1) {
                return cost;
            }

            // Normal moves
            for (int d = 0; d < 2; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < m && nc < n) {
                    int newCost = cost + grid[nr][nc];
                    if (newCost < dist[nr][nc][used]) {
                        dist[nr][nc][used] = newCost;
                        pq.offer(new State(nr, nc, used, newCost));
                    }
                }
            }

            // Teleport
            if (used < k) {
                for (int x = 0; x < m; x++) {
                    for (int y = 0; y < n; y++) {
                        if (grid[x][y] <= grid[r][c]) {
                            if (cost < dist[x][y][used + 1]) {
                                dist[x][y][used + 1] = cost;
                                pq.offer(new State(x, y, used + 1, cost));
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }
}
