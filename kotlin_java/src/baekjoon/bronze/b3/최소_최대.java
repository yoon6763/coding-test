package baekjoon.bronze.b3;

import java.util.Scanner;

public class 최소_최대 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int arr[] = new int[num];
        int min, max;
        for(int i = 0; i<num; i++)
        {
            arr[i] = sc.nextInt();
        }
        min = arr[0];
        max = arr[0];

        for(int i = 0; i<num; i++)
        {
            if(arr[i] < min)
                min = arr[i];
            if(arr[i] > max)
                max = arr[i];
        }
        System.out.println(min+" "+max);
    }
}
