import java.util.*;

class Pair {
    int node;
    int distance;
    Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int[] vis = new int[n];

        // {wt, node}
        pq.add(new Pair(0, 0));

        int sum = 0;

        while (!pq.isEmpty()) {
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();

            if (vis[node] == 1) continue;

            // add node to MST
            vis[node] = 1;
            sum += wt;

            // explore all other nodes (complete graph)
            for (int adjNode = 0; adjNode < n; adjNode++) {
                if (vis[adjNode] == 0) {
                    int cost = Math.abs(points[node][0] - points[adjNode][0])
                             + Math.abs(points[node][1] - points[adjNode][1]);

                    pq.add(new Pair(cost, adjNode));
                }
            }
        }

        return sum;
    }
}
