package baekjoon.bronze.b3;

import java.util.Scanner;

public class 곱셈 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println(num1 * (num2%10));
        System.out.println(num1 * ((num2%100)/10));
        System.out.println(num1 * (num2/100));
        System.out.println(num1*num2);
    }
}
