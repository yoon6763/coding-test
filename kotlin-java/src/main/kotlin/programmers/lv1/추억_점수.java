package programmers.lv1;
import java.util.*;

public class 추억_점수 {
    public static void main(String[] args) {

    }

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int n = photo.length;
        int[] answer = new int[n];

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i = 0; i<name.length; i++) {
            hashMap.put(name[i], yearning[i]);
        }

        for(int i = 0; i<photo.length; i++) {
            int sum = 0;

            for(int j = 0; j < photo[i].length; j++) {
                sum += hashMap.getOrDefault(photo[i][j], 0);
            }
            answer[i] = sum;
        }


        return answer;
    }
}
