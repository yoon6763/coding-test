package programmers.lv2;

import java.util.*;

public class 미로_탈출 {
    public static void main(String[] args) {

    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int n, m;
    int startX = -1;
    int startY = -1;

    public int solution(String[] maps) {

        n = maps.length;
        m = maps[0].length();

        for (int i = 0; i < n; i++) {
            boolean finished = false;

            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    finished = true;
                    startX = i;
                    startY = j;
                    break;
                }
            }
            if (finished) break;
        }

        int leverDistance = bfs(maps, 'L');
        if (leverDistance == -1) return -1;

        int exitDistance = bfs(maps, 'E');
        if (exitDistance == -1) return -1;

        return leverDistance + exitDistance;
    }


    int bfs(String[] maps, char goal) {
        int[][] visited = new int[n][m];

        visited[startX][startY] = 1;

        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(startX, startY));

        while (!q.isEmpty()) {
            Node target = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = target.x + dx[i];
                int ny = target.y + dy[i];

                if (nx < 0 ||
                        nx >= n ||
                        ny < 0 ||
                        ny >= m ||
                        visited[nx][ny] != 0 ||
                        maps[nx].charAt(ny) == 'X') continue;

                visited[nx][ny] = visited[target.x][target.y] + 1;
                q.offer(new Node(nx, ny));

                if (maps[nx].charAt(ny) == goal) {
                    startX = nx;
                    startY = ny;
                    return visited[nx][ny] - 1;
                }
            }
        }
        return -1;
    }
}
