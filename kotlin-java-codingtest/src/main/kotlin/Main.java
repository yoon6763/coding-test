import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int randomSize = 100000000;

        int[] array = new int[randomSize];
        for (int i = 0; i < randomSize; i++) {
            array[i] = random.nextInt(100000000);
        }

        long startTime1 = System.currentTimeMillis();
        Arrays.sort(array);
        long endTime1 = System.currentTimeMillis();

        System.out.println("Array.sort() time: " + (endTime1 - startTime1) + "ms");


        long startTime2 = System.currentTimeMillis();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < randomSize; i++) {
            pq.add(array[i]);
        }

        long endTime2 = System.currentTimeMillis();

        System.out.println("PriorityQueue time: " + (endTime2 - startTime2) + "ms");
    }
}
