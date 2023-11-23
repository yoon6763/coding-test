package codeup;

import java.util.Scanner;

public class 기초_종합_원하는_문자가_입력될_때까지_반복_출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] c = line.split(" ");
        for(int i = 0; i<c.length; i++) {
            System.out.println(c[i]);
            if(c[i].equals("q"))
                break;
        }
    }
}
