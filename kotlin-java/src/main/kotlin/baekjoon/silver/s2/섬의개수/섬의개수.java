package baekjoon.silver.s2.섬의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 섬의개수 {

    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[][] map;
    static int n = 0;
    static int m = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] nm = br.readLine().split(" ");
            n = Integer.parseInt(nm[1]);
            m = Integer.parseInt(nm[0]);
            int cnt = 0;

            if (n == 0 && m == 0) break;

            map = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb.toString());
    }

    static void dfs(int x, int y) {

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 0) continue;

            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }
}
