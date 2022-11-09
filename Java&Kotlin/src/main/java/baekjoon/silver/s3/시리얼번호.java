package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 시리얼번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] text = new String[n];

        for (int i = 0; i < n; i++) {
            text[i] = br.readLine();
        }


        Arrays.stream(text).sorted((a, b) -> {
            if (a.length() > b.length()) {
                return 1;
            } else if (a.length() < b.length()) {
                return -1;
            } else {
                String a1 = a.replaceAll("[^0-9]", ""); // 숫자만 남김
                String b1 = b.replaceAll("[^0-9]", "");

                int sum1 = 0;
                int sum2 = 0;

                for (char iter_a : a1.toCharArray())
                    sum1 += iter_a - '0';

                for (char iter_b : b1.toCharArray())
                    sum2 += iter_b - '0';

                if (sum1 > sum2) {
                    return 1;
                } else if (sum1 < sum2) {
                    return -1;
                } else {
                    return a.compareTo(b);
                }
            }
        }).forEach(System.out::println);
    }
}