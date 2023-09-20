package codeup;

import java.util.Scanner;

public class 기초_종합_함께_문제_푸는_날_설명 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();

        int i = 1;
        for(i = 1; ;i++) {
            if(i % a1 == 0 & i % a2 == 0 & i % a3 == 0) {
                break;
            }
        }
        System.out.println(i);
    }
}
