package baekjoon.bronze.b2;

import java.util.Scanner;

public class 수정렬하기 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int num[] = new int[count];

        for(int i = 0; i<count; i++)
        {
            num[i] = sc.nextInt();
        }

        for(int i = 0; i<num.length; i++)
        {
            for(int j = i; j<num.length; j++)
            {
                if(num[j] < num[i])
                {
                    int temp = num[j];
                    num[j] = num[i];
                    num[i] = temp;
                }
            }
        }
        for(int i = 0; i<num.length; i++)
            System.out.println(num[i]);
    }
}
