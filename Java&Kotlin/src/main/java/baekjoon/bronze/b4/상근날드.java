package baekjoon.bronze.b4;

import java.util.Scanner;

public class 상근날드 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();

        int ham = a;
        int ju = d;

        if (ham > b)
            ham = b;
        if (ham > c)
            ham = c;
        if (ju > e)
            ju = e;

        System.out.print(ham+ju-50);

    }
}
