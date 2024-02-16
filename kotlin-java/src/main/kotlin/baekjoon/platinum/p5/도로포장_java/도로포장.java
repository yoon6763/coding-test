package baekjoon.platinum.p5.도로포장_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int to;
    long cost;
    int paveCount;

    public Edge(int to, long cost, int paveCount) {
        this.to = to;
        this.cost = cost;
        this.paveCount = paveCount;
    }

    @Override
    public int compareTo(Edge other) {
        return Long.compare(this.cost, other.cost);
    }
}

public class 도로포장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, cost, 0));
            graph[to].add(new Edge(from, cost, 0));
        }

        long[][] distance = new long[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                distance[i][j] = Long.MAX_VALUE;
            }
        }
        distance[1][0] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.cost > distance[cur.to][cur.paveCount]) {
                continue;
            }

            for (Edge next : graph[cur.to]) {
                if (cur.paveCount < k && distance[next.to][cur.paveCount + 1] > distance[cur.to][cur.paveCount]) {
                    distance[next.to][cur.paveCount + 1] = distance[cur.to][cur.paveCount];
                    pq.add(new Edge(next.to, distance[next.to][cur.paveCount + 1], cur.paveCount + 1));
                }

                if (distance[next.to][cur.paveCount] > distance[cur.to][cur.paveCount] + next.cost) {
                    distance[next.to][cur.paveCount] = distance[cur.to][cur.paveCount] + next.cost;
                    pq.offer(new Edge(next.to, distance[next.to][cur.paveCount], cur.paveCount));
                }
            }
        }

        long minDistance = Long.MAX_VALUE;
        for (long d : distance[n]) {
            minDistance = Math.min(minDistance, d);
        }

        System.out.println(minDistance);
    }
}
