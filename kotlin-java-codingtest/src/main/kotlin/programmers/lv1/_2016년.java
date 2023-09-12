package programmers.lv1;

import java.time.LocalDate;

public class _2016년 {
    public String solution(int a, int b) {
        LocalDate ld = LocalDate.of(2016, a, b);
        String answer = String.valueOf(ld.getDayOfWeek());
        answer = answer.substring(0,3);
        return answer;
    }
}
