package baekjoon.bronze.b2;

import java.util.Scanner;

public class 간지干支 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        year = year%60;


        char first = '?';

        if(year%12 == 0)
            first = 'I';
        else if (year%12 == 1)
            first = 'J';
        else if (year%12 == 2)
            first = 'K';
        else if (year%12 == 3)
            first = 'L';
        else if (year%12 == 4)
            first = 'A';
        else if (year%12 == 5)
            first = 'B';
        else if (year%12 == 6)
            first = 'C';
        else if (year%12 == 7)
            first = 'D';
        else if (year%12 == 8)
            first = 'E';
        else if (year%12 == 9)
            first = 'F';
        else if (year%12 == 10)
            first = 'G';
        else if (year%12 == 11)
            first = 'H';

        int second = (year+6)%10;

        String s = Integer.toString(second);
        s = first + s;
        System.out.println(s);
    }
}
