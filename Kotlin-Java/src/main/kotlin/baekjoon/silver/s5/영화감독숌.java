package baekjoon.silver.s5;

import java.util.Scanner;

public class 영화감독숌 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int n = 665;
        int rept = 0;

        while(true)
        {
            int count = 0;
            int length = (int)(Math.log10(n)+1);

            int saven = n;

            for(int i = 0; i<length; i++)
            {
                if(saven % 10 == 6)
                {
                    count++;
                    if(count == 3)
                    {
                        rept++;
                        break;
                    }
                }
                else
                    count = 0;
                saven = saven/10;
            }

            if(rept == num)
            {
                System.out.println(n);
                break;
            }
            n++;
        }
    }
}
