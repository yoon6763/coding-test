package baekjoon.unrated;

import java.util.Random;

public class 랜덤게임 {
    public static void main(String[] args)
    {

        Random ran = new Random();

        System.out.println(ran.nextInt(10)+1);
    }
}