package programmers.lv3;

public class 미로_탈출_명령어 {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    String[] d = {"d", "l", "r", "u"};
    String[] path;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        path = new String[k];
        int distance = getDistance(x, y, r, c);
        if (distance > k || (distance % 2 != k % 2)) return "impossible";
        if (!dfs(n, m, x, y, r, c, k, 0)) return "impossible";
        return String.join("", path);
    }

    boolean dfs(int n, int m, int x, int y, int r, int c, int k, int depth) {
        if (depth == k) return x == r && y == c;
        if (getDistance(x, y, r, c) > k - depth) return false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
            path[depth] = d[i];
            if (dfs(n, m, nx, ny, r, c, k, depth + 1)) return true;
        }
        return false;
    }

    int getDistance(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }
}