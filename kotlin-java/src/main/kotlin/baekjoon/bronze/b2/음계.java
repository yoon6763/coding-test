package baekjoon.bronze.b2;

import java.util.Scanner;

public class 음계 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num[] = new int[8];

        boolean asc = true;
        boolean des = true;

        for(int i = 0; i<8; i++)
        {
            num[i] = sc.nextInt();
            if(num[i] != i+1)
                asc = false;
            if(num[i] != (8-i))
                des = false;
        }

        if(asc)
            System.out.println("ascending");
        else if(des)
            System.out.println("descending");
        else
            System.out.println("mixed");
    }
}
