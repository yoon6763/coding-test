package baekjoon.bronze.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이상한_나라의_암호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 2; ; i++) {
            String input = br.readLine();
            if (input.equals("Was it a cat I saw?")) {
                break;
            }

            for (int j = 0; j < input.length(); j += i) {
                sb.append(input.charAt(j));
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
