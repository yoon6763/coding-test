package codeup;

import java.util.Scanner;

public class 기초_1차원배열_이상한_출석_번호_부르기2_설명 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String trush = sc.nextLine();
        String[] line = sc.nextLine().split(" ");

        for(int i = 0; i < line.length; i++) {
            System.out.print(line[line.length - i - 1]+" ");
        }
    }
}
