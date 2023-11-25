package baekjoon.bronze.b3;

import java.util.Arrays;
import java.util.Scanner;

public class 다면체 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            int[] s = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int v = s[0];
            int e = s[1];
            System.out.println(2 + e - v);
        }
    }
}
