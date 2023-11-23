package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문서_검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String pattern = br.readLine();

        int cnt = 0;

        outer:
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (i + j >= str.length()) break outer;
                if (str.charAt(i + j) != pattern.charAt(j)) continue outer;
            }

            cnt++;
            i += pattern.length() - 1;
        }

        System.out.println(cnt);
    }
}
