package codeup;

import java.util.Scanner;

public class 기초_1차원배열_이상한_출석_번호_부르기3_설명 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String trush = sc.nextLine();
        String[] line = sc.nextLine().split(" ");

        int min = 23;

        for(int i = 0; i<line.length; i++) {
            if (min > Integer.parseInt(line[i]))
                min = Integer.parseInt(line[i]);
        }
        System.out.println(min);
    }
}
