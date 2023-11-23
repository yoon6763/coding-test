package baekjoon.bronze.b3;

import java.util.Scanner;

public class 알람_시계 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int min = sc.nextInt();
        int temp;

        min = min - 45;
        if(min < 0)
        {
            temp = -min;
            hour--;
            min = 60 - temp;
        }
        if(hour < 0)
        {
            hour = 23;
        }

        System.out.print(hour+" "+min);

    }

}