package codeup;

import java.text.DecimalFormat;
import java.util.Scanner;

public class 기초_종합_수_나열하기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double initial = sc.nextInt();
        int interval = sc.nextInt();
        int target = sc.nextInt();

        for(int i = 1; i<target; i++)
            initial = initial * interval;
        DecimalFormat df = new DecimalFormat("#");
        System.out.println(df.format(initial));
    }
}
