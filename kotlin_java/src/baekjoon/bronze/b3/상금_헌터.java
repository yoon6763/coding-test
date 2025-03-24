package baekjoon.bronze.b3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 상금_헌터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] fest1 = {500, 300, 200, 50, 30, 10};
        int[] fest2 = {512, 256, 128, 64, 32};
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int money = 0;

            String[] ab = br.readLine().split(" ");
            int f1 = Integer.parseInt(ab[0]);
            int f2 = Integer.parseInt(ab[1]);

            if (f1 == 1) money += fest1[0];
            else if (f1 > 1 && f1 <= 3) money += fest1[1];
            else if (f1 > 3 && f1 <= 6) money += fest1[2];
            else if (f1 > 6 && f1 <= 10) money += fest1[3];
            else if (f1 > 10 && f1 <= 15) money += fest1[4];
            else if (f1 > 15 && f1 <= 21) money += fest1[5];

            if (f2 == 1) money += fest2[0];
            else if (f2 > 1 && f2 <= 3) money += fest2[1];
            else if (f2 > 3 && f2 <= 7) money += fest2[2];
            else if (f2 > 7 && f2 <= 15) money += fest2[3];
            else if (f2 > 15 && f2 <= 31) money += fest2[4];

            sb.append(money * 10000).append("\n");
        }
        System.out.print(sb);
    }
}
