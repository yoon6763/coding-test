package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x){
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public int solution(int[][] maps) {

        Queue<Point> q = new LinkedList<Point>();

        q.offer(new Point(0,0));

        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        int[][] visited = new int[maps.length][maps[0].length];

        visited[0][0] = 1;

        while(!q.isEmpty()) {
            Point target = q.poll();

            for(int i = 0; i<4; i++) {
                int nx = target.getX() + dx[i];
                int ny = target.getY() + dy[i];

                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length || maps[nx][ny] == 0 || visited[nx][ny] > 0) continue;

                visited[nx][ny] = visited[target.getX()][target.getY()] + 1;

                if(nx == maps.length-1 && ny == maps[0].length-1) {
                    return visited[nx][ny];
                }

                q.offer(new Point(nx, ny));
            }
        }


        return -1;
    }
}
