package codeup;

import java.util.Scanner;

public class 기초_종합_주사위를_2개_던지면_설명 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int first = sc.nextInt();
        int second = sc.nextInt();

        for(int i = 1; i<=first; i++) {
            for(int j = 1; j<=second; j++) {
                System.out.println(i+" "+j);
            }
        }
    }
}
