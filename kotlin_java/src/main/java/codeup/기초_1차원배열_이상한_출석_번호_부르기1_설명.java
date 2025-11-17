package codeup;

import java.util.Scanner;

public class 기초_1차원배열_이상한_출석_번호_부르기1_설명 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String inputline = sc.nextLine();
        String[] line = inputline.split(" ");
        int[] nums = new int[line.length];

        for(int i = 0; i< nums.length; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }

        int[] student = new int[23];
        for(int i = 0; i<student.length; i++) {
            student[i] = 0;
        }
        for(int i = 0; i<nums.length; i++) {
            student[nums[i]-1]++;
        }
        for(int i = 0; i<23; i++) {
            System.out.print(student[i] + " ");
        }
    }
}
