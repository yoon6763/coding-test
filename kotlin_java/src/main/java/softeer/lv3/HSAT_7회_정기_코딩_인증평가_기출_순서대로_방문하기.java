package softeer.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HSAT_7회_정기_코딩_인증평가_기출_순서대로_방문하기 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = 0;
    static Node[] path;
    static boolean[][] visited;
    static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        map = new int[n][n];
        path = new Node[m];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            path[i] = new Node(Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1);
        }

        visited[path[0].x][path[0].y] = true;
        backTracking(path[0].x, path[0].y, 1);
        System.out.println(answer);
    }

    public static void backTracking(int x, int y, int depth) {
        if (x == path[depth - 1].x && y == path[depth - 1].y) {
            if (depth == m) {
                answer++;
                return;
            }
            depth++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || map[nx][ny] != 0) continue;

            visited[nx][ny] = true;
            backTracking(nx, ny, depth + 1);
            visited[nx][ny] = false;
        }
    }
}