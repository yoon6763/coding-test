package baekjoon.bronze.b1;

import java.util.Scanner;

public class 더하기사이클 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int s_num = num;
        int count = 0;

        do
        {
            int one = num%10;
            int two = (num-one)/10;
            int sum = one+two;

            num = one*10 + sum%10;
            count++;
        }while(num != s_num);

        System.out.println(count);

    }
}
