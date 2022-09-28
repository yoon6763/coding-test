package baekjoon.bronze.b5;

import java.util.Scanner;

public class 사분면고르기 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int sa;

        if(x > 0)
        {
            if(y > 0)
                sa = 1;
            else
                sa = 4;
        }
        else
        {
            if(y>0)
                sa = 2;
            else
                sa = 3;
        }
        System.out.print(sa);


    }

}