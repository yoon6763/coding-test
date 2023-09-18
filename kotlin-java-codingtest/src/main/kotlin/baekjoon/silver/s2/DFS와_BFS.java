package baekjoon.silver.s2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS와_BFS {
    static int[][] graph;
    static boolean[] visited;
    static int n;
    static int m;
    static int startPoint;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        startPoint = sc.nextInt();

        graph = new int[1001][1001];
        visited = new boolean[1001];

        for(int i = 0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = graph[y][x] = 1;
        }

        dfs(startPoint);
        visited = new boolean[1001];
        bfs();
    }

    static void dfs(int p) {
        visited[p] = true;
        System.out.print(p+" ");

        for(int j = 1; j<=n; j++) {
            if(graph[p][j] == 1 && visited[j] == false) {
                dfs(j);
            }
        }
    }

    static void bfs() {
        System.out.println();

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startPoint);
        visited[startPoint] = true;
        System.out.print(startPoint + " ");

        while (queue.isEmpty() == false) {
            int temp = queue.poll();

            for(int j = 1; j<=n; j++) {
                if(graph[temp][j] == 1 && visited[j] == false) {
                    queue.add(j);
                    visited[j] = true;
                    System.out.print(j+" ");
                }
            }
        }
    }
}