package codeup;

import java.util.Scanner;

public class 기초_종합_짝수_합_구하기_설명 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int result = 0;
        for(int i = 2; i<=num; i++) {
            if(i %2 == 0) {
                result = result + i;
            }
        }
        System.out.println(result);
    }
}
