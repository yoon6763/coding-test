package baekjoon.bronze.b5;

import java.util.Scanner;

public class X보다작은수 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int min = sc.nextInt();

        for(int i = 0; i<n; i++)
        {
            int temp = sc.nextInt();
            if(min > temp)
                System.out.print(temp+" ");
        }

    }
}
