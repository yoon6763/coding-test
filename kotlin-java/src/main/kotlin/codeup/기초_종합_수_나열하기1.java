package codeup;

import java.text.DecimalFormat;
import java.util.Scanner;

public class 기초_종합_수_나열하기1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double initial = sc.nextInt();
        int interval = sc.nextInt();
        int index = sc.nextInt();

        for(int i = 1; i<index; i++) {
            initial = initial + interval;
        }
        DecimalFormat df = new DecimalFormat("#");
        System.out.println(df.format(initial));

    }
}
