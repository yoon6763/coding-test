package codeup;

import java.util.Scanner;

public class 기초_2차원배열_성실한_개미 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[][] = new int[10][10];

        for (int i = 0; i < 10; i++) {
            String[] temp = sc.nextLine().split(" ");
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        if (arr[1][1] == 2) {
            arr[1][1] = 9;
        } else {
            arr[1][1] = 9;
            int x = 1;
            int y = 1;
            while (true) {
                if (arr[x + 1][y] == 1 && arr[x][y + 1] == 1) {
                    break;
                }

                if (arr[x][y + 1] == 2) {
                    arr[x][y + 1] = 9;
                    break;
                }

                if (arr[x][y + 1] == 0) {
                    y++;
                    arr[x][y] = 9;
                } else if (arr[x][y + 1] == 1 && arr[x + 1][y] == 2) {
                    arr[x + 1][y] = 9;
                    break;
                } else if (arr[x + 1][y] == 0) {
                    x++;
                    arr[x][y] = 9;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
