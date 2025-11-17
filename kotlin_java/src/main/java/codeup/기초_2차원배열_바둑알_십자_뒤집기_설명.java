package codeup;

import java.util.Scanner;

public class 기초_2차원배열_바둑알_십자_뒤집기_설명 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[][] = new int[19][19];

        for (int i = 0; i < arr.length; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        int num = sc.nextInt();
        int target[][] = new int[2][num];

        for (int i = 0; i < num; i++) {
            target[0][i] = sc.nextInt() - 1;
            target[1][i] = sc.nextInt() - 1;
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[target[0][i]][j] == 0) {
                    arr[target[0][i]][j] = 1;
                } else {
                    arr[target[0][i]][j] = 0;
                }
            }
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][target[1][i]] == 0) {
                    arr[j][target[1][i]] = 1;
                } else {
                    arr[j][target[1][i]] = 0;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }

    }
}
