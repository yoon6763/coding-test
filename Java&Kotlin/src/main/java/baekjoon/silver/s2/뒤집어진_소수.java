package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뒤집어진_소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        long origin = Long.parseLong(line);
        long originCopy = origin;

        if (!isPrime(origin)) {
            System.out.println("no");
            return;
        }

        long reverse = 0L;

        while (originCopy > 0) {
            long temp = originCopy % 10;
            if (temp == 6) {
                temp = 9L;
            } else if (temp == 9) {
                temp = 6L;
            } else if (temp == 3 || temp == 4 || temp == 7) {
                System.out.println("no");
                return;
            }
            reverse = reverse * 10 + temp;
            originCopy /= 10;
        }

        if (isPrime(reverse)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
