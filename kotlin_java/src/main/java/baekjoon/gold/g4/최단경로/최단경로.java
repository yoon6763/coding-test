package baekjoon.gold.g4.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로 {

    static int MAX_VALUE = 987654321;

    static class Edge implements Comparable<Edge> {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ve = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int V = ve[0];
        int E = ve[1];

        ArrayList<Edge>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, cost));
        }

        int[] distance = dijkstra(graph, V, start);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if (distance[i] == MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(distance[i]).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static int[] dijkstra(ArrayList<Edge>[] graph, int V, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        int[] distance = new int[V + 1];
        Arrays.fill(distance, MAX_VALUE);
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            for (Edge next : graph[cur.to]) {
                int new_cost = distance[cur.to] + next.cost;
                if (new_cost < distance[next.to]) {
                    distance[next.to] = new_cost;
                    pq.offer(new Edge(next.to, new_cost));
                }
            }
        }

        return distance;
    }
}
