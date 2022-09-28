package baekjoon.bronze.b5;

import java.util.Scanner;

public class AplusB_7 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int i;
        int a , b;


        for(i = 0; i < T; i++)
        {
            a = sc.nextInt();
            b = sc.nextInt();

            System.out.println("Case #"+(i+1)+": "+(a+b));

        }



    }
}
