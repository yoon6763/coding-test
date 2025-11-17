package programmers.lv3.퍼즐_조각_채우기;

import java.util.ArrayList;
import java.util.HashSet;

public class 퍼즐_조각_채우기 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] game_board = {{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}};
        int[][] table = {{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};
        System.out.println(solution.solution(game_board, table));

//        solution = new Solution();
//        game_board = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 1}};
//        table = new int[][]{{1, 1, 1}, {1, 0, 0}, {0, 0, 0}};
//        System.out.println(solution.solution(game_board, table));
    }
}

class Solution {

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;
            return this.x == node.x && this.y == node.y;
        }

        @Override
        public int hashCode() {
            return this.x * 1000 + this.y;
        }
    }

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};

    int[][] gameBoard;
    int[][] table;
    boolean[] usedBlock;
    boolean[][] visited;
    int[][] visitedBlock;
    ArrayList<ArrayList<Integer>> graph;
    int n;
    int answer = 0;

    ArrayList<ArrayList<Integer>> blockPaths = new ArrayList<>();
    ArrayList<Integer> blockSize = new ArrayList<>();

    public int solution(int[][] game_board, int[][] table) {
        this.gameBoard = game_board;
        this.table = table;

        n = game_board.length;
        visited = new boolean[n][n];
        visitedBlock = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 0 || visited[i][j]) continue;
                ArrayList<Integer> blockPath = new ArrayList<>();
                HashSet<Node> visitedSet = new HashSet<>();
                findBlock(i, j, blockPath, visitedSet);
                blockPaths.add(blockPath);
                blockSize.add(visitedSet.size());
            }
        }

        visited = new boolean[n][n];
        graph = new ArrayList<>();

        int boardEmptyIndex = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (gameBoard[i][j] == 1 || visited[i][j]) continue;
                HashSet<Node> visitedSet = new HashSet<>();
                findEmptyDistrictInBoard(i, j, visitedSet, boardEmptyIndex);

                ArrayList<Integer> connect = new ArrayList<>();

                nextTableBlock:
                for (int tableBlockIndex = 0; tableBlockIndex < blockPaths.size(); tableBlockIndex++) {
                    if (visitedSet.size() != blockSize.get(tableBlockIndex)) continue;
                    for (Node startPoint : visitedSet) {
                        for (int dir = 0; dir < 4; dir++) {
                            if (canPutBlock(startPoint.x, startPoint.y, tableBlockIndex, dir, visitedSet, boardEmptyIndex)) {
                                connect.add(tableBlockIndex);
                                continue nextTableBlock;
                            }
                        }
                    }
                }

                boardEmptyIndex++;

                graph.add(connect);
            }
        }

        usedBlock = new boolean[blockPaths.size()];
        backTacking(0, 0);

        return answer;
    }

    void backTacking(int index, int score) {
        answer = Math.max(answer, score);

        for (int i = index; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                int blockIndex = graph.get(i).get(j);
                if (usedBlock[blockIndex]) continue;
                usedBlock[blockIndex] = true;
                backTacking(i + 1, score + blockSize.get(blockIndex));
                usedBlock[blockIndex] = false;
            }
        }
    }

    void findEmptyDistrictInBoard(int x, int y, HashSet<Node> visitedSet, int index) {
        visited[x][y] = true;
        visitedSet.add(new Node(x, y));
        visitedBlock[x][y] = index;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (visited[nx][ny] || gameBoard[nx][ny] != 0) continue;

            findEmptyDistrictInBoard(nx, ny, visitedSet, index);
        }
    }

    boolean canPutBlock(int x, int y, int tableBlockIndex, int dir, HashSet<Node> visitedSet, int boardEmptyIndex) {
        ArrayList<Integer> blockPath = blockPaths.get(tableBlockIndex);
        Node cur = new Node(x, y);

        for (int i = 0; i < blockPath.size(); i++) {
            cur.x += dx[(blockPath.get(i) + dir) % 4];
            cur.y += dy[(blockPath.get(i) + dir) % 4];
            if (cur.x < 0 || cur.x >= n || cur.y < 0 || cur.y >= n) return false;
            if (visitedBlock[cur.x][cur.y] != boardEmptyIndex) return false;
        }

        return true;
    }


    void findBlock(int x, int y, ArrayList<Integer> blockPath, HashSet<Node> visitedSet) {
        visited[x][y] = true;
        visitedSet.add(new Node(x, y));

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (visited[nx][ny] || table[nx][ny] != 1) continue;

            blockPath.add(i);
            findBlock(nx, ny, blockPath, visitedSet);
            blockPath.add((i + 2) % 4);
        }
    }

}
