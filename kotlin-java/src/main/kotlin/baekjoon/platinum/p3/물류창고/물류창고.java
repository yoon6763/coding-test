package baekjoon.platinum.p3.물류창고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 물류창고 {
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        long cost;

        Edge(int from, int to, long cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return -Long.compare(cost, o.cost);
        }
    }

    static Map<Integer, Long>[] graph;
    static long[] componentSize;
    static long[] ans;
    static int n;
    static int m;
    static int k;
    static int[] parent;

    public static int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }

    public static void union(int a, int b, long cost) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;

        if (componentSize[pa] < componentSize[pb]) {
            int temp = pa;
            pa = pb;
            pb = temp;
        }
        parent[pb] = pa;
        componentSize[pa] += componentSize[pb];
        componentSize[pb] = 0;

        Map<Integer, Long> tempMap = new HashMap<>(graph[pb]);
        for (Map.Entry<Integer, Long> entry : tempMap.entrySet()) {
            int key = entry.getKey();
            long value = entry.getValue();
            if (graph[pa].containsKey(key)) {
                ans[key] += graph[pa].get(key) * value * cost;
            } else {
                graph[pa].put(key, 0L);
            }
            graph[pa].put(key, graph[pa].get(key) + value);
        }
        graph[pb].clear();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        componentSize = new long[n + 1];
        parent = new int[n + 1];
        graph = new Map[n + 1];
        ans = new long[k + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            graph[i] = new HashMap<>();
            graph[i].put(Integer.parseInt(st.nextToken()), 1L);
            componentSize[i] = 1;
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken())));
        }

        Collections.sort(edges);

        for (Edge edge : edges) {
            union(edge.from, edge.to, edge.cost);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= k; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.println(sb);
    }
}
