package groom.groomthonchallenge.p17_통신망분석;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Group implements Comparable<Group> {
        int minNumOfNode;
        double computerCnt;
        double edgeCnt;

        public Group(int minNumOfNode, int computerCnt, int edgeCnt) {
            this.minNumOfNode = minNumOfNode;
            this.computerCnt = computerCnt;
            this.edgeCnt = edgeCnt;
        }

        @Override
        public int compareTo(Group o) {
            // 1. 밀집도가 높은 순
            double std1 = this.edgeCnt / this.computerCnt - o.edgeCnt / o.computerCnt;

            if (std1 < 0) return 1;
            else if (std1 > 0) return -1;
            else {
                // 2. 컴퓨터 수가 많은 순
                double std2 = this.computerCnt - o.computerCnt;
                if (std2 > 0) return 1;
                else if (std2 < 0) return -1;
                else {
                    // 3. 노드 번호가 작은 순
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
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);

            // 양방향 그래프
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                // 1번 컴퓨터부터 시작을 하므로 그룹 내 가장 작은 컴퓨터 개수는 탐색을 시작하는 컴퓨터의 번호임
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

        // 정렬 조건에 만족하는 그룹을 탐색
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
                // 이미 방문한 노드건, 방문하지 않은 노드건 간선의 개수를 증가시킴
                nowEdgeSize++;

                if (!visited[connectedNode]) {
                    // 방문하지 않은 노드라면 그룹의 크기를 증가시키고, 방문 처리를 함
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
