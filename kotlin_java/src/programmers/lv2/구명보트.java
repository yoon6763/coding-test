package programmers.lv2;

import java.util.Arrays;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int n = people.length;
        int answer = 0;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            answer++;
        }

        return left == right ? answer + 1 : answer;
    }
}
