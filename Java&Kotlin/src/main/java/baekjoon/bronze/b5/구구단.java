package baekjoon.bronze.b5;

import java.util.Scanner;

public class 구구단 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for(int i = 1; i<=9;i++)
        {
            System.out.println(num + " * "+i+" = "+num*i);
        }
    }
}
