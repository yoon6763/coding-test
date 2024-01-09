package programmers.lv2.전력망을_둘로_나누기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 전력망을_둘로_나누기_위상정렬 {

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int[] inDegree = new int[n + 1];
        ArrayList<Integer>[] connect = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            connect[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            inDegree[wire[0]]++;
            inDegree[wire[1]]++;
            connect[wire[0]].add(wire[1]);
            connect[wire[1]].add(wire[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 1) {
                queue.add(i);
            }
            rank[i] = 1;
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            answer = Math.min(answer, Math.abs(rank[cur] * 2 - n));

            for (int next : connect[cur]) {
                rank[next] += rank[cur];
                inDegree[next]--;
                if (inDegree[next] == 1) {
                    queue.add(next);
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }
}
