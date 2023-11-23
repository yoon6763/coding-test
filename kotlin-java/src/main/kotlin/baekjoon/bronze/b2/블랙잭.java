package baekjoon.bronze.b2;

import java.util.Scanner;

public class 블랙잭 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] temp = line.split(" ");

        int num = Integer.parseInt(temp[0]);
        int max = Integer.parseInt(temp[1]);

        line = sc.nextLine();
        temp = line.split(" ");

        int[] nums = new int[num];
        for(int i = 0; i<num; i++)
            nums[i] = Integer.parseInt(temp[i]);

        int pmax = 0;
        for(int i = 0; i<num; i++)
        {
            for(int j = i+1; j<num; j++)
            {
                for(int k = j+1; k<num; k++)
                {
                    int sum = nums[i]+nums[j]+nums[k];
                    if(sum > max)
                        continue;
                    if(pmax < sum)
                        pmax = sum;
                }
            }
        }

        System.out.println(pmax);
    }
}

