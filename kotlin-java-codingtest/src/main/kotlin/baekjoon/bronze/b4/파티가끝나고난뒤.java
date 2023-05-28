package baekjoon.bronze.b4;

import java.util.Scanner;

public class 파티가끝나고난뒤 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int ratio = sc.nextInt();
        int answer = sc.nextInt();
        answer *= ratio;
        int[] per = new int[5];

        for(int i = 0; i<5; i++)
            per[i] = sc.nextInt();

        for(int i = 0; i<5; i++)
            System.out.print(per[i]-answer+" ");
    }
}
