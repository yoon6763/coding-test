package codeup;

import java.util.Scanner;

public class 기초_종합_3의_배수는_통과_설명 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        for(int i = 1; i<=input; i++) {
            if(i%3 == 0)
                continue;
            System.out.print(i+" ");
        }
    }
}
