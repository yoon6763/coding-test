package baekjoon.bronze.b4;

import java.util.Scanner;

public class 방학_숙제 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double num[] = new double[5];
        for(int i = 0; i<5; i++)
            num[i] = sc.nextDouble();
        double day = Math.ceil(num[1] / num[3]);
        double day2 = Math.ceil(num[2] / num[4]);
        if (day < day2)
            day = day2;
        System.out.println((int)(num[0]-day));
    }
}
