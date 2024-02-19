package baekjoon.gold.g1.도로검문_자바;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 도로검문_자바 {

    static class Edge implements Comparable<Edge> {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int n = 0;
    static int m = 0;
    static ArrayList<Edge>[] graph;
    static int[] distance;
    static int[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        graph = new ArrayList[n + 1];
        distance = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] inputEdge = br.readLine().split(" ");
            int from = Integer.parseInt(inputEdge[0]);
            int to = Integer.parseInt(inputEdge[1]);
            int cost = Integer.parseInt(inputEdge[2]);
            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        path = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            path[i] = -1;
        }

        int shortPath = dijkstra();
        int maxPath = 0;
        int i = n;
        while (i > 0) {
            maxPath = Math.max(maxPath, dijkstra(path[i], i));
            i = path[i];
        }

        System.out.println((maxPath == Integer.MAX_VALUE) ? -1 : maxPath - shortPath);
    }

    static int dijkstra() {
        for (int i = 0; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[1] = 0;

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(1, 0));

        while (!q.isEmpty()) {
            Edge cur = q.poll();
            if (cur.cost > distance[cur.to]) continue;

            for (Edge next : graph[cur.to]) {
                if (distance[next.to] > distance[cur.to] + next.cost) {
                    distance[next.to] = distance[cur.to] + next.cost;
                    q.add(new Edge(next.to, distance[next.to]));
                    path[next.to] = cur.to;
                }
            }
        }
        return distance[n];
    }

    static int dijkstra(int a, int b) {
        for (int i = 0; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[1] = 0;

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(1, 0));

        while (!q.isEmpty()) {
            Edge cur = q.poll();
            if (cur.cost > distance[cur.to]) continue;

            for (Edge next : graph[cur.to]) {
                if (a == cur.to && b == next.to) continue;
                if (distance[next.to] > distance[cur.to] + next.cost) {
                    distance[next.to] = distance[cur.to] + next.cost;
                    q.add(new Edge(next.to, distance[next.to]));
                }
            }
        }
        return distance[n];
    }
}
