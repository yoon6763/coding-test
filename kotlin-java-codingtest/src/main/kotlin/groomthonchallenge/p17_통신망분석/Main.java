package groomthonchallenge.p17_통신망분석;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Group implements Comparable<Group> {
        int minNumOfNode;
        double groupSize;
        double edgeSize;

        public Group(int minNumOfNode, int groupSize, int edgeSize) {
            this.minNumOfNode = minNumOfNode;
            this.groupSize = groupSize;
            this.edgeSize = edgeSize;
        }

        @Override
        public int compareTo(Group o) {
            double std1 = this.edgeSize / this.groupSize - o.edgeSize / o.groupSize;

            if (std1 < 0) return 1;
            else if (std1 > 0) return -1;
            else {
                double std2 = this.groupSize - o.groupSize;
                if (std2 > 0) return 1;
                else if (std2 < 0) return -1;
                else {
                    return this.minNumOfNode - o.minNumOfNode;
                }
            }
        }
    }

    static int n = 0;
    static int m = 0;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static ArrayList<Group> groups = new ArrayList<>();
    static int nowGroupSize = 0;
    static int nowMinNumOfNode = Integer.MAX_VALUE;
    static int nowEdgeSize = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                nowMinNumOfNode = i;
                nowGroupSize = 1;
                nowEdgeSize = 0;
                visited[i] = true;
                dfs(i);

                groups.add(new Group(nowMinNumOfNode, nowGroupSize, nowEdgeSize));
            }
        }

        Collections.sort(groups);

        ArrayList<Integer> ansList = new ArrayList<>();
        Arrays.fill(visited, false);

        visited[groups.get(0).minNumOfNode] = true;

        finalDFS(groups.get(0).minNumOfNode, ansList);

        Collections.sort(ansList);

        StringBuilder sb = new StringBuilder();

        ansList.forEach(node -> sb.append(node).append(" "));

        System.out.println(sb.toString().trim());
    }

    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();

            for (int connectedNode : graph[currentNode]) {
                nowEdgeSize++;

                if (!visited[connectedNode]) {
                    nowGroupSize++;
                    visited[connectedNode] = true;
                    stack.push(connectedNode);
                }
            }
        }
    }

    static void finalDFS(int start, ArrayList<Integer> ansList) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        visited[start] = true;
        ansList.add(start);

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();

            for (int node : graph[currentNode]) {
                if (!visited[node]) {
                    visited[node] = true;
                    stack.push(node);
                    ansList.add(node);
                }
            }
        }
    }
}
