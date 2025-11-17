package baekjoon.bronze.b5;

import java.util.Scanner;

public class 팩토리얼 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int i;
        int result = 1;

        for(i=1;i<=n;i++)
        {
            result = result * i;
        }
        System.out.print(result);

    }
}
