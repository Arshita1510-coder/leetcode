class Pair {
    long first;   // distance
    int second;   // node
    Pair(long first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[2], road[1]));
            adj.get(road[1]).add(new Pair(road[2], road[0]));
        }

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((x, y) -> Long.compare(x.first, y.first));

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new Pair(0, 0));
        int mod = (int) (1e9 + 7);

        while (!pq.isEmpty()) {
            long dis = pq.peek().first;
            int node = pq.peek().second;
            pq.poll();

            if (dis > dist[node]) continue;

            for (Pair it : adj.get(node)) {
                int adjNode = it.second;
                long edW = it.first;

                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
                else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] =
                        (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}
