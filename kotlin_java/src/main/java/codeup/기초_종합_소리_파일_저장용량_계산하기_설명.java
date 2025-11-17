package codeup;

import java.text.DecimalFormat;
import java.util.Scanner;

public class 기초_종합_소리_파일_저장용량_계산하기_설명 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double n1 = sc.nextInt();
        double n2 = sc.nextInt();
        double n3 = sc.nextInt();
        double n4 = sc.nextInt();

        double result = (double) n1 * n2 * n3 * n4 / (1024 * 1024 * 8);
        DecimalFormat format = new DecimalFormat("0.0");
        result = (double) Math.round(result * 100) / 100;
        System.out.println(format.format(result) + " MB");
    }
}
