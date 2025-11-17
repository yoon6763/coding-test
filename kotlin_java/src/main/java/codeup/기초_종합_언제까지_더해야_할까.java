package codeup;

import java.util.Scanner;

public class 기초_종합_언제까지_더해야_할까 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();
        int sum = 0;
        for (int i = 0; ; i++) {
            sum = sum + i;
            if (sum >= target) {
                System.out.println(i);
                break;
            }
        }
    }
}
