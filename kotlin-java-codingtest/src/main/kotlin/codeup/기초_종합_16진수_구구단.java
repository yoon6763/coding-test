package codeup;

import java.util.Scanner;

public class 기초_종합_16진수_구구단 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        int int_input = Integer.parseInt(input,16);

        for(int i = 1; i<16; i++) {
            System.out.println(input+"*"+Integer.toHexString(i).toUpperCase()+"="+(Integer.toHexString(i*int_input)).toUpperCase());
        }
    }
}
