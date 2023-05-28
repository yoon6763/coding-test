package baekjoon.bronze.b5;

import java.util.Scanner;

public class 합 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int result = 0;

        for(int i = 1; i<=num; i++)
            result = i+result;
        System.out.println(result);
    }
}
