package baekjoon.bronze.b2;

import java.util.Scanner;

public class 단어의_개수 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        str = str.trim();

        int count = 0;
        for(int i = 0; i<str.length(); i++)
        {
            char temp = str.charAt(i);
            if(temp == ' ')
            {
                count++;
            }
        }
        if(count > 0)
            count++;
        if(count==0 && str.length()>0)
            count++;

        System.out.println(count);
    }
}
