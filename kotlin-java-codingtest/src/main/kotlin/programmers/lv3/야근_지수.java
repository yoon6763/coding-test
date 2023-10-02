package programmers.lv3;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근_지수 {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) pq.add(work);

        for (int i = 0; i < n; i++) {
            int e = pq.poll();
            if (e == 0) break;
            pq.add(e - 1);
        }

        return pq.stream().mapToLong(e -> (long) e * e).sum();
    }
}
