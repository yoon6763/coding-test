package baekjoon.bronze.b2;

import java.util.Scanner;

public class 상수 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int rea = 0;
        int reb = 0;

        while(a > 0)
        {
            rea = rea*10;
            rea = rea + a%10;
            a = a/10;
        }
        while(b > 0)
        {
            reb = reb*10;
            reb = reb + b%10;
            b = b/10;
        }

        if(rea > reb)
            System.out.println(rea);
        else
            System.out.println(reb);
    }
}
