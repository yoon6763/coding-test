package baekjoon.bronze.b5;

import java.util.Scanner;

public class 별_찍기_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int layer = sc.nextInt();
        for (int i = 0; i < layer; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print("*");
            System.out.println("");

        }
    }
}