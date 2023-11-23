package programmers.lv2;

import java.util.PriorityQueue;

public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) pq.add(i);

        int answer = 0;
        while (pq.peek() < K) {
            if (pq.size() == 1) return -1;
            pq.add(pq.poll() + pq.poll() * 2);
            answer++;
        }

        return answer;
    }
}
