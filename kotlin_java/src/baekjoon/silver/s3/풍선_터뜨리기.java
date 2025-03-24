package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 풍선_터뜨리기 {

    static class Element {
        int value;
        int index;

        Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Element> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            deque.addLast(new Element(Integer.parseInt(st.nextToken()), i + 1));
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            Element cur = deque.removeFirst();

            sb.append(cur.index).append(" ");
            if (deque.isEmpty()) break;

            if (cur.value > 0) {
                for (int i = 0; i < cur.value - 1; i++) {
                    deque.addLast(deque.removeFirst());
                }
            } else {
                for (int i = 0; i < -cur.value; i++) {
                    deque.addFirst(deque.removeLast());
                }
            }
        }

        System.out.print(sb);
    }
}
