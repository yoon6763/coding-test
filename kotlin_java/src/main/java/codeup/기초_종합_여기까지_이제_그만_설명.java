package codeup;

import java.util.Scanner;

public class 기초_종합_여기까지_이제_그만_설명 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        int result = 0;
        int cnt = 1;

        while (result < input) {
            result = result + cnt;
            cnt++;
        }
        System.out.println(result);
    }
}
