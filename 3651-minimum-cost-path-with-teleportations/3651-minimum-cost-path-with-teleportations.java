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
        int m = grid.length, n = grid[0].length;

        int[][][] dist = new int[m][n][k + 1];
        for (int[][] layer : dist)
            for (int[] row : layer)
                Arrays.fill(row, Integer.MAX_VALUE);

        // Preprocess cells by value
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                cells.add(new int[]{grid[i][j], i, j});

        cells.sort(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<State> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a.cost)
        );

        dist[0][0][0] = 0;
        pq.offer(new State(0, 0, 0, 0));

        int[] dr = {0, 1};
        int[] dc = {1, 0};

        // teleportUsed -> pointer in sorted cells
        int[] teleIdx = new int[k + 1];

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int r = cur.r, c = cur.c;
            int used = cur.used, cost = cur.cost;

            if (cost > dist[r][c][used]) continue;

            if (r == m - 1 && c == n - 1)
                return cost;

            // Normal moves
            for (int d = 0; d < 2; d++) {
                int nr = r + dr[d], nc = c + dc[d];
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
                while (teleIdx[used] < cells.size() &&
                       cells.get(teleIdx[used])[0] <= grid[r][c]) {

                    int[] cell = cells.get(teleIdx[used]);
                    int x = cell[1], y = cell[2];

                    if (cost < dist[x][y][used + 1]) {
                        dist[x][y][used + 1] = cost;
                        pq.offer(new State(x, y, used + 1, cost));
                    }
                    teleIdx[used]++;
                }
            }
        }

        return -1;
    }
}
