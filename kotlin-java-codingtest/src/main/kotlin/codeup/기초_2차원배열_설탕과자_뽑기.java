package codeup;

import java.util.Scanner;

public class 기초_2차원배열_설탕과자_뽑기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int arr[][] = new int[s1][s2];

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            int d = sc.nextInt();
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            if (d == 0) {
                for (int j = 0; j < len; j++) {
                    arr[x][y + j] = 1;
                }
            } else {
                for (int j = 0; j < len; j++) {
                    arr[x + j][y] = 1;
                }
            }
        }

        for (int i = 0; i < s1; i++) {
            for (int j = 0; j < s2; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

