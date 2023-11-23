package codeup;

import java.util.Scanner;

public class 기초_2차원배열_바둑판에_흰_돌_놓기_설명 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[19][19];
        for (int i = 0; i < 19; i++)
            for (int j = 0; j < 19; j++)
                arr[i][j] = 0;

        int num = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < num; i++) {
            String[] line = sc.nextLine().split(" ");
            arr[Integer.parseInt(line[0]) - 1][Integer.parseInt(line[1]) - 1] = 1;
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
