package baekjoon.gold.g5._86_에이티식스_1_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _86_에이티식스_1 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static int n;
    static boolean[] enemyVisited;
    static ArrayList<Point> enemies = new ArrayList<>();
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        int startX = 0, startY = 0;

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 1) {
                    enemies.add(new Point(i, j));
                }
            }
        }

        if (startX % 2 == startY % 2) {
            for (Point enemy : enemies) {
                if (enemy.x % 2 != enemy.y % 2) {
                    System.out.println("Shorei");
                    return;
                }
            }
        } else {
            for (Point enemy : enemies) {
                if (enemy.x % 2 == enemy.y % 2) {
                    System.out.println("Shorei");
                    return;
                }
            }
        }

        enemyVisited = new boolean[enemies.size()];
        backTracking(startX, startY, 0, 0);

        System.out.println("Undertaker");
        System.out.println(minTime);


    }

    private static void backTracking(int x, int y, int time, int depth) {
        if (depth == enemies.size()) {
            minTime = Math.min(minTime, time);
            return;
        }

        for (int i = 0; i < enemies.size(); i++) {
            if (enemyVisited[i]) continue;
            enemyVisited[i] = true;

            Point enemy = enemies.get(i);

            int spentTime = Math.max(Math.abs(x - enemy.x), Math.abs(y - enemy.y));
            backTracking(enemy.x, enemy.y, time + spentTime, depth + 1);
            enemyVisited[i] = false;
        }
    }
}
