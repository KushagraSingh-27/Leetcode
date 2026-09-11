class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], t = e[2];
            adj.get(u).add(new int[]{v, t});
            adj.get(v).add(new int[]{u, t});
        }

        int[][] bestCost = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(bestCost[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            }
        );

        bestCost[0][0] = passingFees[0];
        pq.offer(new int[]{bestCost[0][0], 0, 0});

        int answer = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int time = cur[1];
            int u = cur[2];

            if (cost > bestCost[u][time]) {
                continue;
            }

            if (u == n - 1) {
                answer = Math.min(answer, cost);
                return cost;
            }

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int tEdge = edge[1];
                int newTime = time + tEdge;

                if (newTime > maxTime) {
                    continue;
                }

                int newCost = cost + passingFees[v];

                if (newCost < bestCost[v][newTime]) {
                    bestCost[v][newTime] = newCost;
                    pq.offer(new int[]{newCost, newTime, v});
                }
            }
        }

        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }
}