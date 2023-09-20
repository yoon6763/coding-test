package codeup;

import java.util.Scanner;

public class 기초_종합_369_게임의_왕이_되자_설명 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = "";
        for(int i = 1; i<=n; i++) {
            if(i % 3 == 0) {
                str = str + "X ";
            } else {
                str = str + i+" ";
            }
        }
        System.out.println(str.trim());
    }
}
