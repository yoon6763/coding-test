package baekjoon.bronze.b2;

import java.util.Scanner;

public class 숫자의개수 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        long abc = a*b*c;
        long abc_n;

        int[] num = {0,0,0,0,0,0,0,0,0,0};

        int k;

        while(abc>0)
        {
            abc_n = abc % 10;
            for(k=0; k<10; k++)
            {
                if(abc_n == k)
                {
                    num[k]++;
                }
            }
            abc = abc/10;
        }
        for(k=0;k<10;k++)
        {
            System.out.println(num[k]);
        }
    }
}
