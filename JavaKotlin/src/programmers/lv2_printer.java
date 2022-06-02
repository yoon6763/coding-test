package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class lv2_printer {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,1,3,4};
        System.out.print(solution.solution(arr,2));
    }

    static class Solution {
        public int solution(int[] priorities, int location) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            int answer = 0;

            for (int i = 0; i < priorities.length; i++) queue.add(priorities[i]);

            while (!queue.isEmpty()) {
                for (int i = 0; i < priorities.length; i++) {
                    if (priorities[i] == queue.peek()) {
                        answer++;
                        if (i == location) {
                            return answer;
                        }
                        queue.poll();
                    }
                }
            }
            return -1;
        }
    }
}
