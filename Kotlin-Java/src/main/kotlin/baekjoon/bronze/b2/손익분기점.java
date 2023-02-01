package baekjoon.bronze.b2;

import java.util.Scanner;

public class 손익분기점 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();


        long num;

        if ((c-b) <= 0)
            num = -1;
        else
        {

            num = a / (c-b);


            if(num <0)
                num = -1;
            else {
                num = (int)num;
                num++;
            }
        }


        System.out.print(num);
    }
}
